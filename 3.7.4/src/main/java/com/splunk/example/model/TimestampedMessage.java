package com.splunk.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TimestampedMessage {
    private final String time;
    private final String from;
    private final String subject;
    private final String body;

    @JsonCreator
    public TimestampedMessage(@JsonProperty("time") String time,
                              @JsonProperty("from") String from,
                              @JsonProperty("subject") String subject,
                              @JsonProperty("body") String body) {
        this.time = time;
        this.from = from;
        this.subject = subject;
        this.body = body;
    }

    public String getTime() {
        return time;
    }

    public String getFrom() {
        return from;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
