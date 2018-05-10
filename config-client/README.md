如何在不重启 config-client 服务的情况下让项目中引用的配置信息更新呢？ 
 

config-client 工程中添加依赖监控模块，其中包含了/refresh刷新API

 
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
            <optional>true</optional>
</dependency>
 

在需要自动更新配置变量的Java类上，使用注解 @RefreshScope 修饰　　

 

 以后当我们再更新git上面的配置文件后，在 config-client 端执行POST 请求 http://localhost:8080/refresh 就可以更新刷新配置变量到内存中了。