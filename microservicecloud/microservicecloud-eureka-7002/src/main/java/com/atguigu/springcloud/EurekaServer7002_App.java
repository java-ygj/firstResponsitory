package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //RurakaServer�������������࣬��������΢����ע�����
public class EurekaServer7002_App {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer7002_App.class, args);
	}
//��ô�鿴ע���Ƿ�ɹ�
	
	//1. ����EurakaServer
	//2. �����������localhost:7001
}
