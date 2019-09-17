package com.hqyj.personel.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.mapper.ContractMapper;
import com.hqyj.personel.mapper.DepartmentMapper;
import com.hqyj.personel.mapper.UserMapper;
import com.hqyj.personel.po.Contract;
import com.hqyj.personel.po.Department;
import com.hqyj.personel.po.User;
import com.hqyj.personel.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService {
	@Autowired
	private ContractMapper contractMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public HashMap<String, Object> getContractBySql(Contract cnt) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 计算sql查询的起始索引
		int start = (cnt.getPage() - 1) * cnt.getRows();
		cnt.setStart(start);
		// 查询结果集
		List<User> userList = contractMapper.selectContractBySql(cnt);
		// 计算user的总条数
		int total = contractMapper.selectCount();
		// 放数据
		map.put("total", total);
		map.put("rows", userList);
		return map;
	}

	@Override
	public int addContract(Contract cnt, RedirectAttributes ra) {
		/*做判断这个employee存不存在*/
		User i = userMapper.getUserByemployeeNo(cnt.getEmployeeNo());
		System.out.println(cnt+"cnt--------------");
		if(i==null) {
			 ra.addAttribute("message","不存在这个员工，不可添加档案！");
			 return 0;
		}else {
			/*添加员工姓名和部门id和部门名称*/
			cnt.setName(i.getName());
			cnt.setDepartmentId(i.getDepartmentId());
			Department de =  departmentMapper.selectByPrimaryKey(i.getDepartmentId());
			cnt.setDepartmentName(de.getDepartmentName());
			ra.addAttribute("message","检索到此员工，可添加档案！");
		}
		System.out.println(cnt+"cnttainjai1hu1");
		return contractMapper.insert(cnt);
	}

	@Override
	public int updateContract(Contract cnt) {
		/*做判断，这个修改的employee存不存在*/
		User i = userMapper.getUserByemployeeNo(cnt.getEmployeeNo());
		if(i==null) {
			 return 0;
		}else {
			/*修改员工姓名和部门id和部门*/
			cnt.setName(i.getName());
			cnt.setDepartmentId(i.getDepartmentId());
			Department de =  departmentMapper.selectByPrimaryKey(i.getDepartmentId());
			cnt.setDepartmentName(de.getDepartmentName());
		}
		return contractMapper.updateByPrimaryKeySelective(cnt);
	}

	@Override
	public int delContractByIds(String id) {
		if("".equals(id)){
			return 0;
		}else {
			String [] str = id.split(",");
			for (String strId : str) {
				int i = contractMapper.deleteByPrimaryKey(Integer.parseInt(strId));
				if(i==0) {
					return 0;
				}
			}
		}
		return 1;
	}

}
