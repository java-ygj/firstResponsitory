package com.atguigu.springcloud.controller;
//不会有service，dao等等层次。

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;
/*	1. 官网地址：
	https://docs.spring.io/spring-framework/docs/4.3.7.RELEASE/javadoc-api/org/springframework/web/client/RestTemplate.html
	2. 使用：
	使用restTemplate访问restful接口非常的简单粗暴无脑。
	(url, requestMap, ResponseBean.class)这三个参数分别代表 
	REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。

*/
@RestController//依然加上restcontroller注解

public class DeptController_Consumer {
//	private static final String REST_URL_PREFIX="http://localhost:8001";//直接访问的8001端口没有通过euraka-server
	/*
	 * spring: application: name: microservicecloud-dept 对外暴露的微服务名字，8001provider类的yml配置
	 */
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
	@Autowired
	private RestTemplate restTemplate;//rest模板
	//	RestTemplate提供了多种便捷访问远程Http服务的方法， 
	//	是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集
	
	@RequestMapping(value = "consumer/dept/add") //注意这里的consumer没有加上，/consumer
	public boolean add(Dept dept) {//在配置文件里面配好了，可以直接用
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, boolean.class);
	}
	
	@RequestMapping(value = "consumer/dept/get/{id}")
	public Dept get(@PathVariable long id) {//在配置文件里面配好了，可以直接用
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "consumer/dept/list")
	public List<Dept> list() {//在配置文件里面配好了，可以直接用
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
	}
	
	//测试@EnableDiscoveryClient,消费端可以调用服务发现
	@RequestMapping(value="/consumer/dept/discovery") 
	public Object discovery()
	  {
	return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
	  }
}
