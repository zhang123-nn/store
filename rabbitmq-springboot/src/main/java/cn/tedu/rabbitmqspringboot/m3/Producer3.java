package cn.tedu.rabbitmqspringboot.m3;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class Producer3 {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        while (true) {
            System.out.println("输入消息:  ");
            String msg = new Scanner(System.in).nextLine();
            amqpTemplate.convertAndSend("logs","",msg);
        }


    }

}
