## 实现跟踪
在完成了准备工作之后，接下来我们开始进行本章的主题内容，为上面的trace-1和trace-2来添加服务跟踪功能。通过Spring Cloud Sleuth的封装，
我们为应用增加服务跟踪能力的操作非常简单，只需要在trace-1和trace-2的pom.xml依赖管理中增加spring-cloud-starter-sleuth依赖即可，具体如下：

```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
```
* eureka-consumer-feign日志：[eureka-consumer-feign,11cf00d97188d713,11cf00d97188d713,false]
* eureka-client日志 [eureka-client,11cf00d97188d713,501001160199636a,false]
- 第一个值：eureka-consumer-feign，它记录了应用的名称，也就是application.properties中spring.application.name参数配置的属性。
- 第二个值：11cf00d97188d713，Spring Cloud Sleuth生成的一个ID，称为Trace ID，它用来标识一条请求链路。一条请求链路中包含一个Trace ID，多个Span ID。
- 第三个值：11cf00d97188d713，Spring Cloud Sleuth生成的另外一个ID，称为Span ID，它表示一个基本的工作单元，比如：发送一个HTTP请求。
- 第四个值：false，表示是否要将该信息输出到Zipkin等服务中来收集和展示。
**上面四个值中的Trace ID和Span ID是Spring Cloud Sleuth实现分布式服务跟踪的核心。在一次服务请求链路的调用过程中，会保持并传递同一个Trace ID
，从而将整个分布于不同微服务进程中的请求跟踪信息串联起来，以上面输出内容为例，eureka-consumer-feign和eureka-client同属于一个前端服务请求来源，所以他们的Trace ID
是相同的，处于同一条请求链路中。**