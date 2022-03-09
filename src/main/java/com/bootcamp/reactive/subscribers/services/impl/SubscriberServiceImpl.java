package com.bootcamp.reactive.subscribers.services.impl;

import com.bootcamp.reactive.subscribers.core.exceptions.SusbcriberBaseException;
import com.bootcamp.reactive.subscribers.entities.Subscriber;
import com.bootcamp.reactive.subscribers.repositories.BlogRepository;
import com.bootcamp.reactive.subscribers.repositories.SubscriberRepository;
import com.bootcamp.reactive.subscribers.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Flux<Subscriber> findAll() {
        return this.subscriberRepository.findAll();
    }

    @Override
    public Mono<Subscriber> save(Subscriber subscriber) {

        return blogRepository
                .findById(subscriber.getBlogId())
                .onErrorResume(e -> Mono.empty())
                .switchIfEmpty(Mono.error(new SusbcriberBaseException(HttpStatus.NOT_FOUND,"Blog no encontrado")))
                .flatMap(blog-> {
                    subscriber.setBlogName(blog.getName());
                    return this.subscriberRepository.save(subscriber);
                });
    }
}
