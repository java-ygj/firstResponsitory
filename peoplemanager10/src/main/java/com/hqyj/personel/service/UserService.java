package com.hqyj.personel.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.po.User;

public interface UserService {

	String login(User user, RedirectAttributes redirectAttributes,HttpServletResponse response,HttpServletRequest req,HttpSession session);

	HashMap<String, Object> getUserBySql(User u);

	String addUser(User u,RedirectAttributes redirectAttributes);

	int updateUser(User u);

	int deleteUserByIdStr(String id);

	String cookieCheck(HttpServletRequest request, HttpServletResponse response);

	String getCheckId(String employeeNo, String password, String emailAddress ,HttpServletResponse resp);

	String regeisteUser(String employeeNo, String password, String emailAddress, String checkId,HttpServletRequest request);

	String clearCookieAndLogout(HttpServletRequest req, HttpServletResponse resp);

	String updatePwdByOldPwd(String employeeNo, String oldPassword, String newPassword, HttpServletRequest req);

	String selectUserByCookie(HttpServletRequest req);

	void generate(HttpServletResponse response, HttpSession session);

	HashMap<String, Object> searchUserByDept(String department,User u);

	HashMap<String, Object> searchUserByDateAndDept(String bTime, String eTime, String deptMsg, User u);

	HashMap<String, Object> searchUserByKey(String key, User u);

}
