package com.hqyj.personel.service;

import java.util.HashMap;
import com.hqyj.personel.po.ClockingRecord;

public interface ClockingService {
	/** 分页查询 */
	HashMap<String, Object> selectByPage(ClockingRecord cr);
	/** 添加考勤记录 */
	int addClocking(ClockingRecord cr);
	
	/** 模糊查询(根据员工编号) */
	HashMap<String, Object> searchByLike(String key,ClockingRecord cr);
	/** 模糊查询(根据时间) */
	HashMap<String, Object> searchByDate(String key, ClockingRecord cr);
	
	/** 修改考勤 */
	int updateClocking(ClockingRecord cr);
	
}
