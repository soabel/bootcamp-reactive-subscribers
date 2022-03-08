package com.bootcamp.reactive.subscribers.services;

import com.bootcamp.reactive.subscribers.entities.Subscriber;
import reactor.core.publisher.Flux;

public interface SubscriberService {
    Flux<Subscriber> findAll();
}
