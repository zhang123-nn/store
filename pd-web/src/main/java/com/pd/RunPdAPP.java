package com.pd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication				
@MapperScan("com.pd.mapper")	
public class RunPdAPP extends WebMvcConfigurerAdapter 
implements EmbeddedServletContainerCustomizer {
	
	public static void main(String[] args) {
		SpringApplication.run(RunPdAPP.class, args);
	}
	@Override
	public void configureContentNegotiation
	(ContentNegotiationConfigurer configurer) {
		//设置可以用*.html访问json
		configurer.favorPathExtension(false);
	}
	
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setSessionTimeout(60*30);//单位为秒 0永不过期 		
	}
	/**
	 * 创建Spring 封装的 queue 实例 包含队列的属性
	 * Rabbitmq的自动配置类 ,会在Spring容器中.自动发现Queue实例
	 * 并且按照指定的属性来连接服务器 ,定义队列
	 */
	@Bean
	public Queue orderQueue(){
		return new Queue("orderQueue",true);
	}
}
