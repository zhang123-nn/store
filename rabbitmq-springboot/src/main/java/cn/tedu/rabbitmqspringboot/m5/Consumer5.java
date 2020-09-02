package cn.tedu.rabbitmqspringboot.m5;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *RabbitListener 加到类上 需要@RabbitListener 配合指定处理消息的方法
 * @RabbitListener 加到方法上 就不需要@RabbitListener
 */
@Component
public class Consumer5 {
    //交换机 //队列
    // 绑定
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = "direct_logs",declare = "false"),//
            value = @Queue  //随机命名 非持久,独占,,自动删除
            ,key = {"error"}
    ))
    public void receive(String s){
        System.out.println("消费者1收到"+s);
    }

    //两个随机队列 都绑定一个交换机
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = "direct_logs",declare = "false"),//
            value = @Queue  //随机命名 非持久,独占,,自动删除
            ,key = {"error","info"}
    ))
    public void receive2(String s){
        System.out.println("消费者2收到"+s);
    }
}
