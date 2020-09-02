package cn.tedu.rabbitmqspringboot.m1;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *RabbitListener 加到类上 需要@RabbitListener 配合指定处理消息的方法
 * @RabbitListener 加到方法上 就不需要@RabbitListener
 */
@Component
public class Producer1 {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        amqpTemplate.convertAndSend("hello","hello");
        System.out.println("消息已发送");
    }



}
