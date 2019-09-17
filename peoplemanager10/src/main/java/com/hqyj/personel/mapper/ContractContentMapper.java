package com.hqyj.personel.mapper;

import com.hqyj.personel.po.ContractContent;

public interface ContractContentMapper {
    int deleteByPrimaryKey(Integer contractContentId);

    int insert(ContractContent record);

    int insertSelective(ContractContent record);

    ContractContent selectByPrimaryKey(Integer contractContentId);

    int updateByPrimaryKeySelective(ContractContent record);

    int updateByPrimaryKeyWithBLOBs(ContractContent record);

    int updateByPrimaryKey(ContractContent record);
}