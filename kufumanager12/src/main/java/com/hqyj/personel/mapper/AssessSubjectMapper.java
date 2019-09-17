package com.hqyj.personel.mapper;

import com.hqyj.personel.po.AssessSubject;

public interface AssessSubjectMapper {
    int deleteByPrimaryKey(Integer subjectId);

    int insert(AssessSubject record);

    int insertSelective(AssessSubject record);

    AssessSubject selectByPrimaryKey(Integer subjectId);

    int updateByPrimaryKeySelective(AssessSubject record);

    int updateByPrimaryKey(AssessSubject record);
}