package com.splunk.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExampleMessage {

    private final String from;
    private final String subject;
    private final String body;


    @JsonCreator
    public ExampleMessage(@JsonProperty("from") String from,
                          @JsonProperty("subject") String subject,
                          @JsonProperty("body") String body) {
        this.from = from;
        this.subject = subject;
        this.body = body;
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

//    public void setFrom(String from) {
//        this.from = from;
//    }
//
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
}
