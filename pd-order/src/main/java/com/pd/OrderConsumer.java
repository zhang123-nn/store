package com.pd;

import com.pd.pojo.PdOrder;
import com.pd.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {
    @Autowired
    private OrderService orderService;
    //添加该注解后,会从指定的orderQueue接收消息,
    //并把数据转为 PdOrder 实例传递到此方法
    @RabbitListener(queues="orderQueue")
    public void save(PdOrder pdOrder){
        System.out.println("消费者");
        System.out.println(pdOrder.toString());
        try {
            orderService.saveOrder(pdOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
