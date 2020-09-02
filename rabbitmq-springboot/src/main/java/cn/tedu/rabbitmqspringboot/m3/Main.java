package cn.tedu.rabbitmqspringboot.m3;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("logs",false,false);//非持久,不自动删除
    }

}
