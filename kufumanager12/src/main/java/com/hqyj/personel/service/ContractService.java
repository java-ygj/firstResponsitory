package com.hqyj.personel.service;

import java.util.HashMap;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.po.Contract;

public interface ContractService {

	HashMap<String, Object> getContractBySql(Contract cnt);

	int addContract(Contract cnt, RedirectAttributes redirectAttributes);

	int updateContract(Contract cnt);

	int delContractByIds(String id);

}
