package com.hqyj.personel.mapper;

import com.hqyj.personel.po.PositionPower;

public interface PositionPowerMapper {
    int deleteByPrimaryKey(Integer positionPowerId);

    int insert(PositionPower record);

    int insertSelective(PositionPower record);

    PositionPower selectByPrimaryKey(Integer positionPowerId);

    int updateByPrimaryKeySelective(PositionPower record);

    int updateByPrimaryKey(PositionPower record);
}