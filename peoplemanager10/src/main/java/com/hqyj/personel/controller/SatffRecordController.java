package com.hqyj.personel.controller;
/*员工档案管理*/

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.po.SatffRecord;
import com.hqyj.personel.po.User;
import com.hqyj.personel.service.SatffRecordService;

@Controller
public class SatffRecordController {
	@Autowired
	private SatffRecordService satffRecordService;

	@RequestMapping(method = RequestMethod.GET, value = "satffRecord.do")
	public String satffRecord() {
		return "satffrecord";
	}

	/**
	 * sql分页查询
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "selectRecordBySql.do")
	public HashMap<String, Object> userLoad(SatffRecord sr) {

		return satffRecordService.getRecordBySql(sr);
	}

	/**
	 * 添加档案
	 * 
	 * @param addRecord
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "addRecord.do")
	public int addRecord(SatffRecord sr,RedirectAttributes redirectAttributes) {

		return satffRecordService.addRecord(sr,redirectAttributes);
	}
	/**
	 * 修改档案
	 * 
	 * @param updateRecord
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "updateRecord.do")
	public int updateRecord(SatffRecord sr) {

		return satffRecordService.updateRecord(sr);
	}
	
	/**
	 * 修改档案
	 * 
	 * @param delRecord
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "delRecord.do")
	public int delRecord(String id) {

		return satffRecordService.delRecordByIds(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
