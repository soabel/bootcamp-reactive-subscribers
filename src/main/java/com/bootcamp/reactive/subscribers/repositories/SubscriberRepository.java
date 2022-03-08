package com.bootcamp.reactive.subscribers.repositories;

import com.bootcamp.reactive.subscribers.entities.Subscriber;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SubscriberRepository extends ReactiveCrudRepository<Subscriber, Integer> {
}
