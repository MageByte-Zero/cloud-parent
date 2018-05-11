package com.zero.consumer.service;

import com.zero.common.model.account.UserInfo;

/**
 * @author jianqing.li
 * @date 2018/5/7
 */
public interface UserService {
    String listUser();

    UserInfo queryUser(long id);
}
