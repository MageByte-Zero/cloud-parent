package com.zero.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author jianqing.li
 * @date 2018/4/26
 */
@RestController
public class DcController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 这里请求的host位置并没有使用一个具体的IP地址和端口的形式，而是采用了服务名的方式组成。那么这样的请求为什么可以调用成功呢？
     * 因为Spring Cloud Ribbon有一个拦截器，它能够在这里进行实际调用的时候，自动的去选取服务实例，并将实际要请求的IP地址和端口
     * 替换这里的服务名，从而完成服务接口的调用。
     * @return
     */
    @GetMapping("/consumer")
    public String dc() {
        String url = "http://eureka-client/dc";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("uid", 10086);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<String> exchange = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, String.class);
        String body = exchange.getBody();
        return body;
    }

}
