package cn.tedu.rabbitmqspringboot.m1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test1 {
    @Autowired
    private Producer1 p;
    @Test
    public void test1(){
       p.send();
    }

}
