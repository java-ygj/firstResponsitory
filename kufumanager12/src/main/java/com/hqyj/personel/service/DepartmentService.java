package com.hqyj.personel.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.po.Department;

public interface DepartmentService {

	HashMap<String, Object> getDepartmentBySql(Department dpt);

	int addDepartment(Department dpt, RedirectAttributes redirectAttributes);

	int updateDepartment(Department department);

	int delDepartmentByIds(String id);

	List<Department> getAllDepartments();

}
