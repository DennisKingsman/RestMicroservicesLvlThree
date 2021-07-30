package com.mcs.lvl.three.configprojectdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class GreetingController {

    @Value("${my.greeting: default hello}")
    private String greetingMessage;

    @Value("${my.list.values}")
    private List<String> values;

    @GetMapping("/greeting")
    public String getGreeting() {
        values.forEach(log::info);
        return greetingMessage;
    }

}
