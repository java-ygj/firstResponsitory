package com.hqyj.personel.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.po.User;
import com.hqyj.personel.service.UserService;

/*登陸管理等等*/
@Controller
public class CommonController {
	@Autowired
	private UserService userService;

	/* 跳转到登录页面 */
	@RequestMapping("loginPage.do")
	public String loginPage(HttpServletRequest request, HttpServletResponse response) {

		return userService.cookieCheck(request, response);
	}

	/*
	 * 登陆验证
	 * 
	 */
	@RequestMapping("login.do")
	public String login(User user, RedirectAttributes redirectAttributes, HttpServletResponse resp,
			HttpServletRequest req,HttpSession session) {
		System.out.println("----------" + user);
		return userService.login(user, redirectAttributes, resp, req,session);
	}

	/* 无权限页面 */
	@RequestMapping("noPower.do")
	public String noPower() {
		return "nopower";
	}

	/* 跳转到index */
	@RequestMapping("index.do")
	public String index() {
		return "index";
	}

	/* 跳转到headpage */
	@RequestMapping("head.do")
	public String head() {
		return "headpage";
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "getUserMsg.do", produces = {
			"application/json;charset=UTF-8" })
	public String getUserMsg(HttpServletRequest req) {

		return userService.selectUserByCookie(req);
	}

	/*
	 * https://www.cnblogs.com/lsjBlog/p/9497089.html
	 */	/* 生成验证码 */
	@RequestMapping(value = "getVerifyCode.do")
	public void generate(HttpServletResponse response, HttpSession session) {
		userService.generate(response,session);
	}
	

}
