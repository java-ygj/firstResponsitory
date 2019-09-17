package com.hqyj.personel.mapper;

import com.hqyj.personel.po.RecruitMessage;
import com.hqyj.personel.po.RecruitMessageWithBLOBs;

public interface RecruitMessageMapper {
    int deleteByPrimaryKey(Integer recuritId);

    int insert(RecruitMessageWithBLOBs record);

    int insertSelective(RecruitMessageWithBLOBs record);

    RecruitMessageWithBLOBs selectByPrimaryKey(Integer recuritId);

    int updateByPrimaryKeySelective(RecruitMessageWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RecruitMessageWithBLOBs record);

    int updateByPrimaryKey(RecruitMessage record);
}