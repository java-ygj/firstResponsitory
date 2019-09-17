package com.hqyj.personel.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.po.Contract;
import com.hqyj.personel.service.ContractService;

/*合同管理*/
@Controller
public class ContractController {
	@Autowired
	private ContractService contractService;
	
	@RequestMapping(method = RequestMethod.GET,value = "contract.do")
	public String contract() {
		return "contract";
	}
	
	/**
	 * sql分页查询
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "selectContractBySql.do")
	public HashMap<String, Object> userLoad(Contract cnt) {

		return contractService.getContractBySql(cnt);
	}

	/**
	 * 添加合同
	 * 
	 * @param addContract
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "addContract.do")
	public int addRecord(Contract cnt,RedirectAttributes redirectAttributes) {

		return contractService.addContract(cnt,redirectAttributes);
	}
	/**
	 * 修改合同内容
	 * 
	 * @param updateContract
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "updateContract.do")
	public int updateRecord(Contract cnt) {

		return contractService.updateContract(cnt);
	}
	
	/**
	 * 删除合同
	 * 
	 * @param delRecord
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "delContract.do")
	public int delRecord(String id) {

		return contractService.delContractByIds(id);
	}
	
	
}
