package com.kkh_chth.articles.observability.server.service;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Mono;

@HttpExchange(url = "/client/hello", accept = "application/json", contentType = "application/json")
public interface ArticleClient {
    @GetExchange
    Mono<String> helloClient();
}
