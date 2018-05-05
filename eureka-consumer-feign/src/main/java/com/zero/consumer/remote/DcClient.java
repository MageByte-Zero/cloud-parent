package com.zero.consumer.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 绑定eureka-client服务
 * @author jianqing.li
 * @date 2018/5/2
 */
@FeignClient("eureka-client")
public interface DcClient {
    @GetMapping("/dc")
    String dc(@RequestParam(value = "uid", required = false) String uid);

}
