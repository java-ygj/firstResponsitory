package com.hqyj.personel.mapper;

import java.util.List;

import com.hqyj.personel.po.SatffRecord;
import com.hqyj.personel.po.User;

public interface SatffRecordMapper {
    int deleteByPrimaryKey(Integer recordId);
    /*3. 添加档案*/
    int insert(SatffRecord record);

    int insertSelective(SatffRecord record);

    SatffRecord selectByPrimaryKey(Integer recordId);
    /*4. 修改档案*/
    int updateByPrimaryKeySelective(SatffRecord record);

    int updateByPrimaryKeyWithBLOBs(SatffRecord record);

    int updateByPrimaryKey(SatffRecord record);
    /*1. 计算数据库的信息条数*/
	int selectCount();
	/*2. 分页查询数据库信息*/
	List<User> selectRecordBySql(SatffRecord sr);
}