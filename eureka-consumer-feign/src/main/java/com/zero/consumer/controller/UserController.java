package com.zero.consumer.controller;

import com.zero.common.model.account.UserInfo;
import com.zero.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String listUser() {
        return userService.listUser();
    }

    @GetMapping("/users/{id}")
    public UserInfo queryUser(@PathVariable long id) {
        UserInfo userInfo = userService.queryUser(id);
        return userInfo;
    }
}
