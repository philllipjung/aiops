package com.splunk.example;

import com.splunk.example.model.TimestampedMessage;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.TextMapGetter;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.springframework.lang.Nullable;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import javax.annotation.PostConstruct;
import java.lang.reflect.Type;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.splunk.example.WsServerController.WS_URL;

@Component
public class WsSubscriber extends StompSessionHandlerAdapter {

    private final static Logger logger = Logger.getLogger(WsSubscriber.class.getName());
    private final ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
    private final WebSocketClient client;
    private final WebSocketStompClient stompClient;
    private StompSession session;

    public WsSubscriber() {
        client = new StandardWebSocketClient();
        stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
    }

    @PostConstruct
    public void runForever() {
        logger.info("Websocket subscriber is starting.");
        pool.scheduleAtFixedRate(this::attemptStartup, 2, 2, TimeUnit.SECONDS);
    }

    @WithSpan
    private void attemptStartup() {
        if (!stompClient.isRunning()) {
            logger.info("Subscriber is attempting connection.");
            stompClient.start();
            stompClient.connect(WS_URL, this);
        }
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        this.session = session;
        pool.shutdown();
        //TODO: Migrate this to WsSubscriber
        session.subscribe("/topic/messages", this);
    }

    @Override
//    @WithSpan("messageReceived")
    public void handleFrame(StompHeaders headers, Object payload) {

        var traceContext = getTraceContext(headers);
        try (var scope = traceContext.makeCurrent()) {
            TimestampedMessage msg = (TimestampedMessage) payload;
            var tracer = GlobalOpenTelemetry.getTracer("Custom_MessageSubscriber");
            var span = tracer.spanBuilder("/topic/messages receive")
                    .setSpanKind(SpanKind.CONSUMER)
                    .setAttribute("x-from", msg.getFrom())
                    .setAttribute("x-subject", msg.getSubject())
                    .startSpan();
            try(var x = span.makeCurrent()) {
                logger.info("Subscriber received:");
                logger.log(Level.INFO, "    {0} | From: {1} | Subject: {2} ",
                        new Object[]{msg.getTime(), msg.getFrom(), msg.getSubject()});
                logger.log(Level.INFO, "    Body: {0} ", msg.getBody());
            }
            finally{
                span.end();
            }
        }
    }

    private static Context getTraceContext(StompHeaders headers) {
        return GlobalOpenTelemetry.getPropagators().getTextMapPropagator()
                .extract(Context.current(), headers, new TextMapGetter<>() {
                    @Nullable
                    @Override
                    public String get(@Nullable StompHeaders carrier, String key) {
                        return carrier.getFirst(key);
                    }

                    @Override
                    public Iterable<String> keys(StompHeaders carrier) {
                        return headers.toSingleValueMap().keySet();
                    }
                });
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.log(Level.WARNING, "ERROR: ", exception);
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        logger.log(Level.WARNING, "TRANSPORT ERROR: ", exception);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return TimestampedMessage.class;
    }
}
