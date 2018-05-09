package com.zero.consumer.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jianqing.li
 * @date 2018/5/3
 */
@FeignClient("eureka-client")
public interface UserServiceRemote {
    @GetMapping("/users")
    String listUser();
}
