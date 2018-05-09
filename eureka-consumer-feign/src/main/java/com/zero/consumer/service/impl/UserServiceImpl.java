package com.zero.consumer.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zero.consumer.remote.UserServiceRemote;
import com.zero.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jianqing.li
 * @date 2018/5/7
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserServiceRemote userServiceRemote;

    @HystrixCommand(fallbackMethod = "fallback")
    @Override
    public String listUser() {
        return userServiceRemote.listUser();
    }

    public String fallback() {
        return "fallback";
    }
}
