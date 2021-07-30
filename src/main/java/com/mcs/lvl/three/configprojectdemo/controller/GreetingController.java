package com.mcs.lvl.three.configprojectdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Value("${my.greeting: default hello}")
    private String greetingMessage;

    @GetMapping("/greeting")
    public String getGreeting() {
        return greetingMessage;
    }

}
