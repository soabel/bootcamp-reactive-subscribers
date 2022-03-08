package com.bootcamp.reactive.subscribers.routers;

import com.bootcamp.reactive.subscribers.handlers.SubscriberHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterConfiguration {

    @Bean
    public RouterFunction<ServerResponse> blogRoutes(SubscriberHandler subscriberHandler) {
        return RouterFunctions.nest(RequestPredicates.path("/subscribers"),
                RouterFunctions
                        .route(GET(""), subscriberHandler::findAll)
        );
    }

}
