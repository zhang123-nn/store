package cn.tedu.rabbitmqspringboot.m5;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class Producer5 {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        while (true) {
            System.out.println("输入消息:  ");
            String msg = new Scanner(System.in).nextLine();

            System.out.println("输入路由键:  ");
            String routingKey = new Scanner(System.in).nextLine();
            amqpTemplate.convertAndSend("logs",routingKey,msg);
        }


    }

}