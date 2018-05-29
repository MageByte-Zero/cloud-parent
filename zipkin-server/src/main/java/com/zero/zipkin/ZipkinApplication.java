package com.zero.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * @author jianqing.li
 * @EnableZipkinServer注解来启动Zipkin Server http方式
 * @EnableZipkinStreamServer 中间件方式
 * @date 2018/5/28
 */
@EnableZipkinServer
//@EnableZipkinStreamServer
@SpringBootApplication
public class ZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
    }
}
