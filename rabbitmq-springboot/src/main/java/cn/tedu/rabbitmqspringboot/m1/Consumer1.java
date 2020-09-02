package cn.tedu.rabbitmqspringboot.m1;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 *RabbitListener 加到类上 需要@RabbitListener 配合指定处理消息的方法
 * @RabbitListener 加到方法上 就不需要@RabbitListener
 */
@Component
public class Consumer1 {
    @RabbitListener(queues = "hello")
    public void receive(String s){
        System.out.println("收到"+s);
    }
}
