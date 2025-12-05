package com.kkh_chth.articles.observability.client.controller;

import com.kkh_chth.articles.observability.client.bean.Article;
import com.kkh_chth.articles.observability.client.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController

public class ClientController {
   private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping("/client/articles")
    public Mono<List<Article>> getArticleList(){
        return clientService.callServerForArticles();
    }
    @GetMapping("/client/hello")
    public Mono<String> helloClient(){
        return Mono.just("hello Server");
    }

}
