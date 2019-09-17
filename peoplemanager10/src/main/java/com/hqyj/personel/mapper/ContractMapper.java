package com.hqyj.personel.mapper;

import java.util.List;

import com.hqyj.personel.po.Contract;
import com.hqyj.personel.po.User;

public interface ContractMapper {
	/*4.真删除，通过主键删除*/
    int deleteByPrimaryKey(Integer contractId);
    /*3.添加以添合同记录*/
    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(Integer contractId);
    /*5.修改contract通过主键*/
    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKeyWithBLOBs(Contract record);

    int updateByPrimaryKey(Contract record);
    /*2. 查询user的list*/
	List<User> selectContractBySql(Contract cnt);
	/*1. 计算数量*/
	int selectCount();
}