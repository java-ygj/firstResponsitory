package com.hqyj.personel.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.mapper.SatffRecordMapper;
import com.hqyj.personel.mapper.UserMapper;
import com.hqyj.personel.po.SatffRecord;
import com.hqyj.personel.po.User;
import com.hqyj.personel.service.SatffRecordService;
@Service
public class SatffRecordServiceImpl implements SatffRecordService {
	@Autowired
	private SatffRecordMapper satffRecordMapper;
	@Autowired
	private UserMapper userMapper;
	@Override
	public HashMap<String, Object> getRecordBySql(SatffRecord sr) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 计算sql查询的起始索引
		int start = (sr.getPage() - 1) * sr.getRows();
		sr.setStart(start);
		// 查询结果集
		List<User> userList = satffRecordMapper.selectRecordBySql(sr);
		// 计算user的总条数
		int total = satffRecordMapper.selectCount();
		// 放数据
		map.put("total", total);
		map.put("rows", userList);
		return map;
	}
	@Override
	public int addRecord(SatffRecord sr,RedirectAttributes ra) {
		/*做判断这个employee存不存在*/
		User i = userMapper.getUserByemployeeNo(sr.getEmpolyeeNo());
		if(i==null) {
			 ra.addAttribute("message","不存在这个员工，不可添加档案！");
			 return 0;
		}else {
			/*添加员工姓名和部门id*/
			sr.setName(i.getName());
			sr.setDepartmentId(i.getDepartmentId());
			ra.addAttribute("message","检索到此员工，可添加档案！");
		}
		return satffRecordMapper.insert(sr);
	}
	@Override
	public int updateRecord(SatffRecord sr) {
		/*做判断这个修改的这个employee存不存在*/
		User i = userMapper.getUserByemployeeNo(sr.getEmpolyeeNo());
		if(i==null) {
			 return 0;
		}else {
			/*修改员工姓名和部门id*/
			sr.setName(i.getName());
			sr.setDepartmentId(i.getDepartmentId());
		}
		return satffRecordMapper.updateByPrimaryKeySelective(sr);
	}
	@Override
	public int delRecordByIds(String id) {
		String [] str = id.split(",");
		for (String strId : str) {
			int i = satffRecordMapper.deleteByPrimaryKey(Integer.parseInt(strId));
			if(i==0) {
				return 0;
			}
		}
		return 1;
	}
}
