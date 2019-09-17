package com.hqyj.personel.mapper;

import com.hqyj.personel.po.PositionDepartment;

public interface PositionDepartmentMapper {
    int deleteByPrimaryKey(Integer positionDepartmentId);

    int insert(PositionDepartment record);

    int insertSelective(PositionDepartment record);

    PositionDepartment selectByPrimaryKey(Integer positionDepartmentId);

    int updateByPrimaryKeySelective(PositionDepartment record);

    int updateByPrimaryKey(PositionDepartment record);
}