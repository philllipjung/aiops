package com.kkh_chth.articles.observability.client.service;


import com.kkh_chth.articles.observability.client.bean.Article;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@HttpExchange(url = "/server/articles", accept = "application/json", contentType = "application/json")
public interface ArticleServer {
    @GetExchange
    Mono<List<Article>> callServerForArticles();
}
