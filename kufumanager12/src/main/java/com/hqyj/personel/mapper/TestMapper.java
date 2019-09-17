package com.hqyj.personel.mapper;

import java.util.List;

import com.hqyj.personel.po.TestPo;

public interface TestMapper {
	
	List<String> searchRole(String userName);
	
	List<String> searchPower(String userName);
	
	
	TestPo getAdminByUserName(String userName);

}
