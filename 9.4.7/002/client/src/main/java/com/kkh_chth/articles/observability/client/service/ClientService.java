package com.kkh_chth.articles.observability.client.service;

import com.kkh_chth.articles.observability.client.bean.Article;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ClientService {

    private final ArticleServer articleServer;

    public ClientService(ArticleServer articleServer) {
        this.articleServer = articleServer;
    }

    public Mono<List<Article>> callServerForArticles() {
        return articleServer.callServerForArticles();
    }
}
