package com.bootcamp.reactive.subscribers.services.impl;

import com.bootcamp.reactive.subscribers.entities.Subscriber;
import com.bootcamp.reactive.subscribers.repositories.SubscriberRepository;
import com.bootcamp.reactive.subscribers.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Override
    public Flux<Subscriber> findAll() {



        return this.subscriberRepository.findAll();
    }
}
