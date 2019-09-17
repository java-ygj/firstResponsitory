package com.hqyj.personel.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.personel.po.PersonelTransferManager;
import com.hqyj.personel.service.PositionTransferService;

/*人事调动管理*/
@Controller
public class TransferController {
	@Autowired
	private PositionTransferService positionTransferService;
	/*网页跳转*/
	@RequestMapping(method = RequestMethod.GET,value = "transfer.do")
	public String transfer() {
		return "transfer";
	}
	/*查询调配记录*/
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,value = "selectPositionTransfer.do")
	public HashMap<String, Object> loadPositionTransfer(PersonelTransferManager personelTransfer){
		
		
		return positionTransferService.loadPositionTransfer(personelTransfer);
	}
	/*增加一条调配信息*/
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST,value ="addPositionTransfer.do",produces={"application/json;charset=UTF-8"})
	public String addPositionTransfer(PersonelTransferManager pTM,String positionDesc) {
		
		return positionTransferService.addPositionTransfer(pTM,positionDesc);
	}
	/*模糊查詢*/
	
		@ResponseBody
		@RequestMapping(method = RequestMethod.GET,value ="searchTransferrByKey.do",produces={"application/json;charset=UTF-8"})
		public HashMap<String, Object> searchTransferrByKey(String key,PersonelTransferManager ptm) {
			
			return positionTransferService.searchTransferrByKey(key,ptm);
		}
	
	
}
