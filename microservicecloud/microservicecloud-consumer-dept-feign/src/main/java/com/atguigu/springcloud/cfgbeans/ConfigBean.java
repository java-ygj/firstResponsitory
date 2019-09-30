package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class ConfigBean 
	{//springboot优化了spring的配置文件   applicationContext.xml   等同于@Configration配置
	//configBean = applicationContext.xml
	@Bean
	@LoadBalanced  //客户端       负载均衡的工具。实现均衡负载
	public RestTemplate getRestTemplate() {//用于发Rest请求，在消费者controller层次调用
		return new RestTemplate();
	}
	
	@Bean
	public IRule myRule() //当再主启动类配置了@RibbonClient注解时候，这个不生效，即@RibbonClient>@Bean
	{
		//return new RandomRule();//随机
		return new RoundRobinRule();//轮换
		//return new RetryRule();//有一个服务down之后，撞几次墙就会跳过，不在撞墙；
	}
	
}
