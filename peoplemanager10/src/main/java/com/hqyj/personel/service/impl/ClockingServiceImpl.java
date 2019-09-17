package com.hqyj.personel.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.personel.mapper.ClockingRecordMapper;
import com.hqyj.personel.po.ClockingRecord;
import com.hqyj.personel.service.ClockingService;

@Service
public class ClockingServiceImpl implements ClockingService {

	@Autowired
	private ClockingRecordMapper mapper;

	/**
	 * 分页查询
	 */
	@Override
	public HashMap<String, Object> selectByPage(ClockingRecord cr) {
		// 创建数据集的map对象
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 计算sql查询的起始索引
		int start = (cr.getPage()-1)*cr.getRows();
		cr.setStart(start);
		// 查询结果集
		List<ClockingRecord> list = mapper.selectByPage(cr);
		// 总条数
		int total = mapper.countAll();
		
		map.put("total", total);
		map.put("rows", list);
		
		return map;
	}

	/**
	 * 添加考勤记录
	 */
	@Override
	public int addClocking(ClockingRecord cr) {
		int i = mapper.addClocking(cr);
		return i;
	}

	/**
	 * 模糊查询(根据员工编号)
	 */
	@Override
	public HashMap<String, Object> searchByLike(String key, ClockingRecord cr) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 计算sql查询的起始索引
		int start = (cr.getPage()-1)*cr.getRows();
		cr.setStart(start);
		//cr.setClockingDate(key);
		cr.setEmployeeNo("%"+key+"%");
		
		// 查询结果集
		List<ClockingRecord> list = mapper.selectByLike(cr);
		// 模糊查询的总条数
		int total = mapper.countByLike(cr);
		
		map.put("total", total);
		map.put("rows", list);
		
		return map;
	}
	
	/**
	 * 根据时间
	 */
	@Override
	public HashMap<String, Object> searchByDate(String key, ClockingRecord cr) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 计算sql查询的起始索引
		int start = (cr.getPage()-1)*cr.getRows();
		cr.setStart(start);
		cr.setClockingDate(key);
		//cr.setEmployeeNo("%"+key+"%");
		
		// 查询结果集
		List<ClockingRecord> list = mapper.selectByDate(cr);
		// 模糊查询的总条数
		int total = mapper.countByDate(cr);
		
		map.put("total", total);
		map.put("rows", list);
		
		return map;
	}

	/**
	 * 修改考勤
	 */
	@Override
	public int updateClocking(ClockingRecord cr) {
		return mapper.updateClocking(cr);
	}

	

	

	
	
}
