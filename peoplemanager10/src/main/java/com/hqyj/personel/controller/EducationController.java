package com.hqyj.personel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*教育培训管理*/
@Controller
public class EducationController {
	@RequestMapping(method = RequestMethod.GET,value = "education.do")
	public String education() {
		return "education";
	}
}
