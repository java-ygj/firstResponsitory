package com.hqyj.personel.mapper;

import java.util.List;

import com.hqyj.personel.po.ClockingRecord;

public interface ClockingRecordMapper {
    /** 分页查询 */
	List<ClockingRecord> selectByPage(ClockingRecord cr);
	/** 总条数 */
	int countAll();
	/** 添加考勤记录 */
	int addClocking(ClockingRecord cr);
	
	/** 模糊查询(根据员工编号) */
	List<ClockingRecord> selectByLike(ClockingRecord cr);
	/** 模糊查询的总条数 */
	int countByLike(ClockingRecord cr);
	/** 模糊查询(根据时间) */
	List<ClockingRecord> selectByDate(ClockingRecord cr);
	/** 模糊查询的总条数 */
	int countByDate(ClockingRecord cr);
	
	/** 修改考勤数据 */
	int updateClocking(ClockingRecord cr);
	
}