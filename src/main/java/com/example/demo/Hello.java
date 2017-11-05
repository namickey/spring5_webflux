package com.example.demo;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.sql.DataSourceDefinition;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@RestController
public class Hello {

    @GetMapping("/")
    Flux<String> hello() {
        return Flux.just("hello world.");
    }

    @GetMapping("/a")
    Flux<String> a() {
        return Flux.just("/a hello.");
    }

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return route(GET("/b"), req -> ok().syncBody("/b webFlux."));
    }

    @Bean
    public RouterFunction<ServerResponse> index() {
        return route(GET("/c"), req -> ok().syncBody("/c syncbody."));
    }

    @Bean
    public RouterFunction<ServerResponse> rice(){
        Food food = new Food();
        food.setName("rice");
        return route(GET("/m"), req -> ok().syncBody(food));
    }

    @GetMapping("/d")
    public Mono<Food> eat(){
        Food food = new Food();
        food.setName("fish");
        return Mono.just(food);
    }

    @Data
    public class Food{
        private String name;
    }
}
