package com.hqyj.personel.mapper;

import com.hqyj.personel.po.Assess;

public interface AssessMapper {
    int deleteByPrimaryKey(Integer assessId);

    int insert(Assess record);

    int insertSelective(Assess record);

    Assess selectByPrimaryKey(Integer assessId);

    int updateByPrimaryKeySelective(Assess record);

    int updateByPrimaryKey(Assess record);
}