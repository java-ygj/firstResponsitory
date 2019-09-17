package com.hqyj.personel.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.po.User;
import com.hqyj.personel.service.UserService;

/*系统管理下
 * 员工信息管理
 * 
 * */
@Controller
public class UserController {

	@Autowired
	private UserService userServie;

	@RequestMapping("user.do")
	public String userManager() {
		return "user";
	}

	/**
	 * sql分页查询
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "selectSql.do")
	public HashMap<String, Object> userLoad(User u) {

		return userServie.getUserBySql(u);
	}

	/**
	 * 添加用户默认密码位123
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "addUser.do",produces={"application/json;charset=UTF-8"})
	public String addUser(User u, RedirectAttributes redirectAttributes) {

		return userServie.addUser(u, redirectAttributes);
	}

	/**
	 * 修改user表
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "updateUser.do")
	public int updateUser(User u) {

		return userServie.updateUser(u);
	}

	/**
	 * 删除user表的记录
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "delUser.do")
	public int deleteUser(String id) {

		return userServie.deleteUserByIdStr(id);
	}

	/* 跳转到注册页面 */
	@RequestMapping(method = RequestMethod.GET, value = "toregiste.do")
	public String toRegistePage() {
		return "registe";
	}

	/*
	 * emailAddress employeeNo password checkId
	 */
	
	
	/**
	 * 验证码的获取
	 * 
	 * @param 
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "getCheckId.do",produces={"application/json;charset=UTF-8"})
	public String getCheckId(String employeeNo, String password, String emailAddress ,HttpServletResponse resp) {
		return userServie.getCheckId(employeeNo, password, emailAddress , resp);

	}
	/* emailAddress
	employeeNo
	password
	checkId */
	/**
	 * 注册
	 * 
	 * @param 
	 * @return 
	 */
	@RequestMapping(method = RequestMethod.POST,value = "regesite.do",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String regesite(String employeeNo, String password, String emailAddress,String checkId ,HttpServletRequest request) {
		
		return userServie.regeisteUser(employeeNo,password,emailAddress,checkId,request);
	}
	/**
	 * 根据部门查询本部门的人员
	 * 
	 * @param 
	 * @return 
	 */
		@RequestMapping(method = RequestMethod.GET,value = "searchUserByDept.do")
		@ResponseBody
		public HashMap<String, Object> searchUserByDept(String Department,User u) {
			HashMap<String, Object> map =  userServie.searchUserByDept(Department,u);
//			System.out.println(map.toString());
			return map;
		}
		
		@RequestMapping(method = RequestMethod.GET,value = "searchDateAndDept.do")
		@ResponseBody
		public HashMap<String, Object> searchUserByDateAndDept(String bTime,String eTime,String DeptMsg,User u){
			System.out.println("be____-"+bTime);
			System.out.println("eTime------"+eTime);
			return userServie.searchUserByDateAndDept(bTime,eTime,DeptMsg,u);
		}
	
		
		@RequestMapping(method = RequestMethod.GET,value = "searchUserByKey.do")
		@ResponseBody
		public HashMap<String, Object> searchUserByKey(String key,User u){
			
			return userServie.searchUserByKey(key,u);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
