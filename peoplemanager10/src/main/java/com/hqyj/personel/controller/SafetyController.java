package com.hqyj.personel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.personel.service.UserService;

/*安全管理*/
@Controller
public class SafetyController {
	@Autowired
	private UserService userService;
	@RequestMapping(method = RequestMethod.GET,value = "logout.do")
	public String clearCookieAndLogout(HttpServletRequest req,HttpServletResponse resp) {
		
		return userService.clearCookieAndLogout(req,resp);
				//"redirect:loginPage.do";
	}
	@RequestMapping(method = RequestMethod.POST,value = "updatePwd.do",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String updatePwd(String employeeNo,String oldPassword,String newPassword,HttpServletRequest req) {
		//System.out.println(employeeNo+"--------"+oldPassword+"-----------"+newPassword);
		return userService.updatePwdByOldPwd(employeeNo,oldPassword,newPassword,req);
	}
	
}
