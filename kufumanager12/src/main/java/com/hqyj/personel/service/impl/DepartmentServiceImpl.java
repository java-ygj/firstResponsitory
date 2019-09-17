package com.hqyj.personel.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.mapper.DepartmentMapper;
import com.hqyj.personel.mapper.UserMapper;
import com.hqyj.personel.po.Department;
import com.hqyj.personel.po.User;
import com.hqyj.personel.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public HashMap<String, Object> getDepartmentBySql(Department dpt) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 计算sql查询的起始索引
		int start = (dpt.getPage() - 1) * dpt.getRows();
		dpt.setStart(start);
		// 查询结果集
		List<User> userList = departmentMapper.selectDepartmentBySql(dpt);
		// 计算deparment的总条数
		int total = departmentMapper.selectCount();
		// 放数据
		map.put("total", total);
		map.put("rows", userList);
		return map;
	}

	@Override
	public int addDepartment(Department dpt, RedirectAttributes redirectAttributes) {

		return departmentMapper.insert(dpt);
	}

	@Override
	public int updateDepartment(Department department) {
		
		return departmentMapper.updateByPrimaryKeySelective(department);
	}

	@Override
	public int delDepartmentByIds(String id) {
		/*删除部门，就会删除这个员工，假删除*/
		if("".equals(id)){
			return 0;
		}else {
			String [] str = id.split(",");
			for (String strId : str) {
				/*设置删除的状态为1*/
				int deleteStatus = 1;
				
				int delId = Integer.parseInt(strId);
				
				/*部门假的删除*/
				int i = departmentMapper.falseDeleteByDepartmentId(delId,deleteStatus);
				
				/*员工，假的删除*/
				int j = userMapper.falseDeleteByDepartmentId(delId,deleteStatus);
				
				if(i==0||j==0) {
					return 0;
				}
			}
		}
		return 1;
	}

	@Override
	public List<Department> getAllDepartments() {
		
		return departmentMapper.selectAllDepartments();
	}

}
