package com.hqyj.personel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*招聘管理*/
@Controller
public class RecruitController {

	
	@RequestMapping(method = RequestMethod.GET,value = "recruit.do")
	public String recurit() {
		return "recruit";
	}
	
	
	
}
