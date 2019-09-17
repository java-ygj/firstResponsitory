package com.hqyj.personel.mapper;

import com.hqyj.personel.po.Grade;

public interface GradeMapper {
    int deleteByPrimaryKey(Integer examId);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer examId);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
}