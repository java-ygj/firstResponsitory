package com.hqyj.personel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.po.TestPo;
import com.hqyj.personel.service.MyTestService;
/*测试类*/
@Controller
public class MyTestController {

	@Autowired
	private MyTestService myTestService;
	/**
	 * ��¼��֤
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST,value="textlogin.do")
	public String login(TestPo tp,RedirectAttributes redirectAttributes) {
		return myTestService.login(tp,redirectAttributes);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "texttologin.do")
	public String toLoginPage() {
		return "logintest";
	}
	@RequestMapping(method = RequestMethod.GET,value = "textindex.do")
	public String index() {
		return "index";
	}
	@RequestMapping(method = RequestMethod.GET,value = "textnoPower.do")
	public String noPower() {
		return "nopower";
	}
	@RequestMapping(method = RequestMethod.GET,value = "textstu.do")
	public String stu() {
		return "stuTest";
	}
	@RequestMapping(method = RequestMethod.GET,value = "textteacher.do")
	public String teacher() {
		return "teacherTest";
	}
}
