package com.mcs.lvl.three.configprojectdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class GreetingController {

    @Value("${my.greeting: default hello}")
    private String greetingMessage;

    @Value("${my.list.values}")
    private List<String> values;

    @Value("#{${my.example.dbValues}}")
    private Map<String, String> dbValues;

    @GetMapping("/greeting")
    public String getGreeting() {
        log.info("Map keys");
        dbValues.keySet().forEach(log::info);
        log.info("Map values");
        dbValues.values().forEach(log::info);
        log.info("List");
        values.forEach(log::info);
        return greetingMessage;
    }

}
