package com.zero.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author jianqing.li
 * @date 2018/5/3
 */
@RestController
public class UserController {
    @GetMapping("/users")
    public String listUser() throws InterruptedException {
        // 为了触发服务降级逻辑，我们可以将服务提供者eureka-client的逻辑加一些延迟
        TimeUnit.SECONDS.sleep(5L);
        return "users controller";
    }
}
