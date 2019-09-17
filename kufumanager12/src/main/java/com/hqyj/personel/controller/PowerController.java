package com.hqyj.personel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*系统管理
 * 主要处理权限分配
 * */
@Controller
public class PowerController {
	
	@RequestMapping(method = RequestMethod.GET,value = "powerPage.do")
	public String powerPage() {
		return "powerfp";
	}
	
}
