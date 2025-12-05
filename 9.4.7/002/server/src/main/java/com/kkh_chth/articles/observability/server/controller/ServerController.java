package com.kkh_chth.articles.observability.server.controller;

import com.kkh_chth.articles.observability.server.bean.Article;
import com.kkh_chth.articles.observability.server.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ServerController {

    private ClientService clientService;
    @GetMapping("/server/articles")
    public Mono<List<Article>> getArticleList(){
        List<Article> alist= new ArrayList<>();
        alist.add(new Article(1,"First Article"));
        alist.add(new Article(2,"Second Article"));
        alist.add(new Article(3,"Third Article"));
        alist.add(new Article(4,"Fourth Article"));
       log.info("Article List : {}",alist);
        log.error("TEST_ERROR :error log print");
        log.debug("TEST_DEBUG :debug log print");
        log.warn("TEST_WARN :warn log print");
        return Mono.just(alist);
    }

    @GetMapping("  ")
    public Mono<String> helloClient(){
        log.error("TEST_ERROR :helloClient print");
        log.debug("TEST_DEBUG :helloClient print");
        log.warn("TEST_WARN :helloClient print");
        return clientService.helloClient();
    }
}
