package com.zero.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc(@RequestParam(value = "uid", required = false) String uid) {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services + ", uid = " + uid);
        return services;
    }

}