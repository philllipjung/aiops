package com.kkh_chth.articles.observability.server.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClientService {

    private final ArticleClient articleServer;

    public ClientService(ArticleClient articleServer) {
        this.articleServer = articleServer;
    }

    public Mono<String> helloClient() {
        return articleServer.helloClient();
    }
}
