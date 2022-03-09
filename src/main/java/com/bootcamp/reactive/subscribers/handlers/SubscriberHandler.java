package com.bootcamp.reactive.subscribers.handlers;

import com.bootcamp.reactive.subscribers.core.exceptions.SusbcriberBaseException;
import com.bootcamp.reactive.subscribers.entities.Subscriber;
import com.bootcamp.reactive.subscribers.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class SubscriberHandler {
    @Autowired
    private SubscriberService subscriberService;

    public Mono<ServerResponse> findAll(ServerRequest request){

        return this.subscriberService.findAll()
                .switchIfEmpty(Mono.error(new SusbcriberBaseException("No se encontró elementos")))
                .collectList()
                .flatMap(list-> ServerResponse.ok().body(Mono.just(list), Subscriber.class));
    }

    public Mono<ServerResponse> findById(ServerRequest serverRequest) {
        return null;
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        return request.bodyToMono(Subscriber.class)
                .flatMap(subscriber -> this.subscriberService.save(subscriber))
                .flatMap(subscriber -> ServerResponse.ok().body(Mono.just(subscriber), Subscriber.class));
    }
}
