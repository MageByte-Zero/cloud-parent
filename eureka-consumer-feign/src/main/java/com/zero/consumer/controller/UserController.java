package com.zero.consumer.controller;

import com.zero.consumer.remote.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jianqing.li
 * @date 2018/5/3
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String dc() {
        return userService.listUser();
    }
}
