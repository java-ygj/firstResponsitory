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
import com.atguigu.springcloud.service.DeptClientService;

/*	1. 官网地址：
	https://docs.spring.io/spring-framework/docs/4.3.7.RELEASE/javadoc-api/org/springframework/web/client/RestTemplate.html
	2. 使用：
	使用restTemplate访问restful接口非常的简单粗暴无脑。
	(url, requestMap, ResponseBean.class)这三个参数分别代表 
	REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。

*/
@RestController // 依然加上restcontroller注解

public class DeptController_Consumer {
	@Autowired
	private DeptClientService service;

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return this.service.get(id);
	}

	@RequestMapping(value = "/consumer/dept/list")
	public List list() {
		return this.service.list();
	}

	@RequestMapping(value = "/consumer/dept/add")
	public Object add(Dept dept) {
		return this.service.add(dept);
	}
}
