package com.hqyj.personel.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.mapper.TestMapper;
import com.hqyj.personel.po.TestPo;
import com.hqyj.personel.service.MyTestService;
@Service
public class MyTestServiceImpl implements MyTestService {

	@Autowired
	private TestMapper testMapper;
	
	@Override
	public String login(TestPo tp, RedirectAttributes ra) {
		//获取shiro令牌
		Subject subject = SecurityUtils.getSubject();
		//
		UsernamePasswordToken token = new UsernamePasswordToken(tp.getSysName(),tp.getSysPwd());
		try {
			//调用登陆
			subject.login(token);
		} catch (UnknownAccountException e) {
			ra.addAttribute("error","账户不存在");
			return "redirect:tologin.do";
		}catch(IncorrectCredentialsException ie) {
			ra.addAttribute("error","密码错误");
			return "redirect:tologin.do";
		}
		return "redirect:index.do";
	}

}
