package com.bootcamp.reactive.subscribers.routers;

import com.bootcamp.reactive.subscribers.entities.Subscriber;
import com.bootcamp.reactive.subscribers.handlers.SubscriberHandler;
import com.bootcamp.reactive.subscribers.services.SubscriberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
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
        @RouterOperations(
            {

                @RouterOperation(path = "/subscribers",
                        produces = {MediaType.APPLICATION_JSON_VALUE},
                        method = RequestMethod.GET,
                        beanClass = SubscriberService.class,
                        beanMethod = "findAll",
                        operation = @Operation(
                                operationId = "findAll",
                                responses = {
                                        @ApiResponse(responseCode = "200",
                                                description = "successful operation",
                                                content = @Content(array=@ArraySchema(schema = @Schema(implementation = Subscriber.class))))},
                                parameters = {})

                )

            })
    public RouterFunction<ServerResponse> blogRoutes(SubscriberHandler subscriberHandler) {
        return RouterFunctions.nest(RequestPredicates.path("/subscribers"),
                RouterFunctions
                        .route(GET(""), subscriberHandler::findAll)
        );
    }

}
