package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController // 包含这个responsebody,前后端分离开发，所以一般用的都是restcontroller
public class DeptController {
	@Autowired
	private DeptService deptService;
	// 服务发现
	@Autowired
	private DiscoveryClient discoveryClient;

	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
				.setDb_source("no this database in MySQL");
	}

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return deptService.add(dept);
	}

	// @PathVariable是spring3.0的一个新功能：接收请求路径中占位符的值,占位符
	@HystrixCommand(fallbackMethod = "processHystrix_Get")//处理异常处理超时处理不顺利情况 
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable Long id) {
		Dept dept = deptService.get(id);
		if (null == dept) {
			throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
		}
		return dept;
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> find(Dept dept) {
		return deptService.list();
	}

	// 服务发现
	// @Autowired
	// private DiscoveryClient discoveryClient;
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery() {
		// 获取的所有的微服务
		List<String> list = discoveryClient.getServices();
		System.out.println("**********" + list);

		// 报错Type mismatch: cannot convert from element type Object to Document
		// 加上泛型才行，找到一个名字叫做MICROSERVICECLOUD-DEPT的微服务spring.application.name
		List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.discoveryClient;// 有问题,返回的是接口，所以返回其实现类对象；也可以自己组装返回对象。
	}

}
