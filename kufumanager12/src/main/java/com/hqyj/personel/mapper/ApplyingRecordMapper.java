package com.hqyj.personel.mapper;

import com.hqyj.personel.po.ApplyingRecord;

public interface ApplyingRecordMapper {
    int deleteByPrimaryKey(Integer applyingId);

    int insert(ApplyingRecord record);

    int insertSelective(ApplyingRecord record);

    ApplyingRecord selectByPrimaryKey(Integer applyingId);

    int updateByPrimaryKeySelective(ApplyingRecord record);

    int updateByPrimaryKey(ApplyingRecord record);
}