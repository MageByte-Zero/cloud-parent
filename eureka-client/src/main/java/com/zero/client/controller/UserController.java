package com.zero.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jianqing.li
 * @date 2018/5/3
 */
@RestController
public class UserController {
    @GetMapping("/users")
    public String listUser() {
        return "users controller";
    }
}
