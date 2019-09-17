package com.hqyj.personel.mapper;

import com.hqyj.personel.po.Recruitment;

public interface RecruitmentMapper {
    int deleteByPrimaryKey(Integer recruitmentId);

    int insert(Recruitment record);

    int insertSelective(Recruitment record);

    Recruitment selectByPrimaryKey(Integer recruitmentId);

    int updateByPrimaryKeySelective(Recruitment record);

    int updateByPrimaryKey(Recruitment record);
}