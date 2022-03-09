package com.bootcamp.reactive.subscribers.repositories.impl;

import com.bootcamp.reactive.subscribers.entities.Blog;
import com.bootcamp.reactive.subscribers.repositories.BlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
public class BlogRepositoryImpl implements BlogRepository {

    private final WebClient client;

    public BlogRepositoryImpl(WebClient.Builder builder,
                              @Value( "${application.urlApiBlog:http://localhost/blogs}" ) String urlApiBlog){
        log.info("urlApiBlog = " + urlApiBlog);

        this.client = builder.baseUrl(urlApiBlog).build();
    }

    @Override
    public Mono<Blog> findById(String id) {
        return this.client.get().uri("/" + id).accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Blog.class);
    }
}
