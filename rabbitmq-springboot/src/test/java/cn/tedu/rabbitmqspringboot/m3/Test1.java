package cn.tedu.rabbitmqspringboot.m3;

import cn.tedu.rabbitmqspringboot.m2.Producer2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test1 {
    @Autowired
    private Producer3 p;
    @Test
    public void test1(){
       p.send();
    }

}
