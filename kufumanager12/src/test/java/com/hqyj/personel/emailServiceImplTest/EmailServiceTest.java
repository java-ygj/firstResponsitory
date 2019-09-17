package com.hqyj.personel.emailServiceImplTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hqyj.personel.service.EmailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mapper.xml","classpath:spring/spring-service.xml"})
public class EmailServiceTest {

	@Autowired
	private EmailService emailService;
	@Test
	public void emailTest() {
		
		emailService.seandMail("1975492517@qq.com", "2325491260@qq.com", "hello", "123456789");
		
	}
	
}
