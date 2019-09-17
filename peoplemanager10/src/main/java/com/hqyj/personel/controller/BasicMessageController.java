package com.hqyj.personel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasicMessageController {
	@RequestMapping(method = RequestMethod.GET,value = "basicMassage.do")
	public String basicMessage() {
		return "basicmessage";
	}
}
