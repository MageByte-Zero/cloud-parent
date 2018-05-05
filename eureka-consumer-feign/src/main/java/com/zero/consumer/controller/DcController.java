package com.zero.consumer.controller;

import com.zero.consumer.remote.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jianqing.li
 * @date 2018/4/26
 */
@RestController
public class DcController {

    @Autowired
    private DcClient dcClient;

    @GetMapping("/consumer")
    public String dc(@RequestParam(value = "uid", required = false) String uid) {
        return dcClient.dc(uid);
    }

}
