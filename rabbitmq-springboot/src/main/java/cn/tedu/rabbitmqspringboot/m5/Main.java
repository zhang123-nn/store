package cn.tedu.rabbitmqspringboot.m5;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct_logs",false,false);//非持久,不自动删除
    }

}
