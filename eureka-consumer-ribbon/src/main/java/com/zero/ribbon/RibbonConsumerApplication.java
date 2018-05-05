package com.zero.ribbon;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableDiscoveryClient 将当前应用加入到服务治理体系中
 */
@EnableDiscoveryClient
@SpringBootApplication
public class RibbonConsumerApplication {

	/**
	 * @LoadBalanced 开启客户端负载均衡
	 * @return
	 */
	@Bean
	@LoadBalanced
    public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(RibbonConsumerApplication.class).web(true).run(args);
	}
}