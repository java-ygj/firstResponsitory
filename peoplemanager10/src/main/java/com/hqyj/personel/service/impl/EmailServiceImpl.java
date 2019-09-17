package com.hqyj.personel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hqyj.personel.service.EmailService;
@Service
public class EmailServiceImpl implements EmailService {
		@Autowired
		private JavaMailSender mailSender;

		@Override
		public void seandMail(String from,String to, String subject, String content) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(from);
			message.setTo(to);
			message.setSubject(subject);
			message.setText(content);
			try {
				mailSender.send(message);
				System.out.println("���ͳɹ�");
			} catch (Exception e) {
				System.out.println("����ʧ��");
				e.printStackTrace();
			}
		}
}
