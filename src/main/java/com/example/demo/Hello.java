package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class Hello {
    @GetMapping("/")
    Flux<String> hello(){
       return Flux.just("hello world.");
    }
}
