package com.hqyj.personel.mapper;

import com.hqyj.personel.po.UserPosition;

public interface UserPositionMapper {
    int deleteByPrimaryKey(Integer employeePositionId);

    int insert(UserPosition record);

    int insertSelective(UserPosition record);

    UserPosition selectByPrimaryKey(Integer employeePositionId);

    int updateByPrimaryKeySelective(UserPosition record);

    int updateByPrimaryKey(UserPosition record);
}