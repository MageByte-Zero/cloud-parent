package com.zero.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {
    @Value("${info.profile}")
    private String test;

    @RequestMapping("/hello")
    public String from() {
        return this.test;
    }
}