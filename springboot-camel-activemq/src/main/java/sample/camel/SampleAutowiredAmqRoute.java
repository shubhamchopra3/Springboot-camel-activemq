package sample.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SampleAutowiredAmqRoute extends RouteBuilder {
String msg="Hello from Camel";
    @Override
    public void configure() throws Exception {
        from("activemq:sample.queue")
            .to("log:sample");

        from("timer://foo?repeatCount=1")     // use from("timer://foo?repeatCount=1")  to send only once the route starts and use  from("timer:bar") to send every second
        .setBody(constant(msg))
        .to("activemq:sample.queue");      //sample.queue is the name of queue
    }

}
