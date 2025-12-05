package com.splunk.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WsAppMain extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WsAppMain.class, args);
    }

}
