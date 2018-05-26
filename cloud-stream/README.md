* @EnableBinding，该注解用来指定一个或多个定义了@Input或@Output注解的接口，以此实现对消息通道（Channel）的绑定。在上面的例子中，
 我们通过@EnableBinding(Sink.class)绑定了Sink接口，该接口是Spring Cloud Stream中默认实现的对输入消息通道绑定的定义，它的源码如下：
* @StreamListener：该注解主要定义在方法上，作用是将被修饰的方法注册为消息中间件上数据流的事件监听器，注解中的属性值对应了
监听的消息通道名。在上面的例子中，我们通过@StreamListener(Sink.INPUT)注解将receive方法注册为对input消息通道的监听处理
器，所以当我们在RabbitMQ的控制页面中发布消息的时候，receive方法会做出对应的响应动作。