这是Hystrix Dashboard的监控首页，该页面中并没有具体的监控信息。从页面的文字内容中我们可以知道，Hystrix Dashboard共支持三种不同的监控方式，依次为：

默认的集群监控：通过URLhttp://turbine-hostname:port/turbine.stream开启，实现对默认集群的监控。
指定的集群监控：通过URLhttp://turbine-hostname:port/turbine.stream?cluster=[clusterName]开启，实现对clusterName集群的监控。
单体应用的监控：通过URLhttp://hystrix-app:port/hystrix.stream开启，实现对具体某个服务实例的监控。
前两者都对集群的监控，需要整合Turbine才能实现，这部分内容我们将在下一篇中做详细介绍。在本节中，我们主要实现对单个服务实例的监控，所以这里我们先来实现单个服务实例的监控。

既然Hystrix Dashboard监控单实例节点需要通过访问实例的/hystrix.stream接口来实现，自然我们需要为服务实例添加这个端点，而添加该功能的步骤也同样简单，只需要下面两步：

在服务实例pom.xml中的dependencies节点中新增spring-boot-starter-actuator监控模块以开启监控相关的端点，并确保已经引入断路器的依赖spring-cloud-starter-hystrix：
```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-hystrix</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

确保在服务实例的主类中已经使用@EnableCircuitBreaker或@EnableHystrix注解，开启了断路器功能。
到这里已经完成了所有的配置，我们可以在Hystrix Dashboard的首页输入http://localhost:2101/hystrix.stream，已启动对“eureka-consumer-ribbon-hystrix”的监控，
点击“Monitor Stream”按钮