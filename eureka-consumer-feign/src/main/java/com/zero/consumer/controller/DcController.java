package com.zero.consumer.controller;

import com.zero.consumer.remote.DcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DcClient dcClient;

    @GetMapping("/consumer")
    public String dc(@RequestParam(value = "uid", required = false) String uid) {
        logger.info("dc start");
        return dcClient.dc(uid);
    }

}
