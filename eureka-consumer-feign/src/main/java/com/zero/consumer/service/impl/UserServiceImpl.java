package com.zero.consumer.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zero.common.model.account.UserInfo;
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

    @Override
    public UserInfo queryUser(long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName("健青");
        userInfo.setLastName("李");
        userInfo.setId(id);
        return userInfo;
    }
}
