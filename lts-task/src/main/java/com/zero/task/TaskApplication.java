package com.zero.task;

import com.github.ltsopensource.spring.boot.annotation.EnableJobClient;
import com.github.ltsopensource.spring.boot.annotation.EnableJobTracker;
import com.github.ltsopensource.spring.boot.annotation.EnableTaskTracker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jianqing.li
 * @date 2018/6/6
 */
@SpringBootApplication
@EnableTaskTracker
@EnableJobTracker
@EnableJobClient
public class TaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }
}
