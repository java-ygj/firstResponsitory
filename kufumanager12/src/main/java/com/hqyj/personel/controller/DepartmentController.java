package com.hqyj.personel.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.po.Department;
import com.hqyj.personel.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(method = RequestMethod.GET, value = "departmentPage.do")
	public String department() {
		return "department";
	}

	/**
	 * sql分页查询
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "selectDepartmentBySql.do")
	public HashMap<String, Object> departmentLoad(Department dpt) {

		return departmentService.getDepartmentBySql(dpt);
	}

	/**
	 * 添加部门
	 * addContract
	 * 
	 * @param department
	 * @param redirectAttributes
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "addDepartment.do")
	public int addDepartment(Department dpt,RedirectAttributes redirectAttributes) {

		return departmentService.addDepartment(dpt,redirectAttributes);
	}
	/**
	 * 修改部门内容
	 * updateContract
	 * @param department
	 * @return
	 */
	@ResponseBody                                         
	@RequestMapping(method = RequestMethod.POST, value = "updateDepartment.do")
	public int updateDepartment(Department department) {
			System.out.println("-------------"+department);
		return departmentService.updateDepartment(department);
	}
	
	/**
	 * 删除部门
	 * delDepartment
	 * 
	 * @param id
	 * @return int
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "delDepartment.do")
	public int delDepartment(String id) {

		return departmentService.delDepartmentByIds(id);
	}
	
	/**
	 * 查询出所有部门
	 * @return
	 */
	@RequestMapping("getAllDepartments.do")
	@ResponseBody
	public List<Department> getAllDepartments(){
		return departmentService.getAllDepartments();
	}
	
}
