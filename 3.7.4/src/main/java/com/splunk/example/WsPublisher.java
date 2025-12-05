package com.splunk.example;

import com.splunk.example.model.ExampleMessage;
import com.splunk.example.util.Items;
import com.splunk.example.util.Names;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.annotations.WithSpan;
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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.splunk.example.WsServerController.WS_URL;

@Component
public class WsPublisher extends StompSessionHandlerAdapter {

    private final static Logger logger = Logger.getLogger(WsPublisher.class.getName());
    private final ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
    private final WebSocketClient client;
    private final WebSocketStompClient stompClient;
    private StompSession session;

    public WsPublisher() {
        client = new StandardWebSocketClient();
        stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
    }

    @PostConstruct
    public void runForever() {
        logger.info("Websocket publisher is starting.");
        pool.scheduleAtFixedRate(this::sendOne, 2, 2, TimeUnit.SECONDS);
    }

    @WithSpan(value="/app/tube publish", kind = SpanKind.PRODUCER)
    private void sendOne() {
        if (!stompClient.isRunning()) {
            logger.info("Publisher is attempting connection.");
            stompClient.start();
            stompClient.connect(WS_URL, this);
            return;
        }

        if (session == null) {
            logger.info("Not sending message (no session)");
            return;
        }

        logger.info("WsPublisher sending a message...");
        String item = Items.random();
        ExampleMessage message = new ExampleMessage(Names.random(), item, "Imagine the silhouette of a " + item);

        StompHeaders headers = new StompHeaders();
        headers.setDestination("/app/tube");

        GlobalOpenTelemetry.getPropagators()
                .getTextMapPropagator()
                .inject(Context.current(), headers, (carrier, key, value) -> {
                    if(carrier != null){
                        carrier.set(key, value);
                    }
                });

        session.send(headers, message);
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        this.session = session;
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.log(Level.WARNING, "ERROR: ", exception);
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        logger.log(Level.WARNING, "TRANSPORT ERROR: ", exception);
    }
}
