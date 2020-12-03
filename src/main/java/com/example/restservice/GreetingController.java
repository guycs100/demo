package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import ch.qos.logback.core.net.server.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);


    @GetMapping("/user/{id}")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        log.info(counter.toString());
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}