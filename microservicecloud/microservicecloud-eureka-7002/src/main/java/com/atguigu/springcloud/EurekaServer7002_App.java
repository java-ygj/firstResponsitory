package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //RurakaServer服务器短启动类，接受其他微服务注册进来
public class EurekaServer7002_App {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer7002_App.class, args);
	}
//怎么查看注册是否成功
	
	//1. 启动EurakaServer
	//2. 在浏览器输入localhost:7001
}
