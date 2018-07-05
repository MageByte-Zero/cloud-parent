package com.zero.tracker;

import com.github.ltsopensource.spring.boot.annotation.EnableJobTracker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jianqing.li
 * @date 2018/7/5
 */
@SpringBootApplication
@EnableJobTracker
public class JobTrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobTrackerApplication.class, args);
    }
}
