package com.splunk.example;

import com.splunk.example.model.ExampleMessage;
import com.splunk.example.model.TimestampedMessage;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import io.opentelemetry.context.propagation.TextMapGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Controller
public class WsServerController {

    public static final String WS_URL = "ws://localhost:8080/tube";
    private SimpMessagingTemplate template;

    @Autowired
    public WsServerController(SimpMessagingTemplate template){
        this.template = template;
    }

    // This is how you might normally do a mapping, but it doesn't provide a way
    // to inject headers into the stomp message....so we have to do it the hard way
    // (see below)
//    @MessageMapping("/tube")
//    @SendTo("/topic/messages")
//    public TimestampedMessage send(ExampleMessage exampleMessage) throws Exception {
//
//        var time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//        return new TimestampedMessage(time, exampleMessage.getFrom(), exampleMessage.getSubject(), exampleMessage.getBody());
//    }

    @MessageMapping("/tube")
    public void routeTube(ExampleMessage exampleMessage, SimpMessageHeaderAccessor headerAccessor) {

        var traceContext = GlobalOpenTelemetry.getPropagators().getTextMapPropagator()
                .extract(Context.current(), headerAccessor, new HeadersAdapter());
        var tracer = GlobalOpenTelemetry.getTracer("Custom_MessageMapping");

        try (var scope = traceContext.makeCurrent()) {
            // Automatically use the extracted SpanContext as parent.
            var serverSpan = tracer.spanBuilder("/tube process")
                    .setSpanKind(SpanKind.SERVER)
                    .startSpan();
            try(Scope x = serverSpan.makeCurrent()){
                doRoute(exampleMessage, headerAccessor);
            }
            finally {
                serverSpan.end();
            }
        }
    }

    private void doRoute(ExampleMessage exampleMessage, SimpMessageHeaderAccessor msgHeaders) {
        var time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        var tsMsg = new TimestampedMessage(time, exampleMessage.getFrom(), exampleMessage.getSubject(), exampleMessage.getBody());

        var headers = new HashMap<>(msgHeaders.toMap());
        GlobalOpenTelemetry.getPropagators()
                .getTextMapPropagator()
                .inject(Context.current(), headers, (carrier, key, value) -> {
                    if(carrier != null){
                        carrier.put(key, value);
                    }
                });
        template.convertAndSend("/topic/messages", tsMsg, headers);
    }

    private static class HeadersAdapter implements TextMapGetter<SimpMessageHeaderAccessor> {
        @Nullable
        @Override
        public String get(@Nullable SimpMessageHeaderAccessor carrier, String key) {
            return carrier.getFirstNativeHeader(key);
        }

        @Override
        public Iterable<String> keys(SimpMessageHeaderAccessor carrier) {
            return carrier.toMap().keySet();
        }
    }
}
