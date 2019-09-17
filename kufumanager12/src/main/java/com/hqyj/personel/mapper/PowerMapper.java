package com.hqyj.personel.mapper;

import com.hqyj.personel.po.Power;

public interface PowerMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Power record);

    int insertSelective(Power record);

    Power selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Power record);

    int updateByPrimaryKey(Power record);
}