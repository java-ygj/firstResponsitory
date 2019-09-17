package com.hqyj.personel.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.personel.po.ClockingRecord;
import com.hqyj.personel.service.ClockingService;

/*考勤管理*/
@Controller
public class ClockingController {
	
	@Autowired
	private ClockingService service;
	
	/**
	 * 进入考勤主页
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value = "toClockingPage.do")
	public String toClockingPage() {
		return "clocking";
	}
	
	/**
	 *  分页管理
	 * @param cr
	 * @return
	 */
	@RequestMapping("clockingPage.do")
	@ResponseBody
	public HashMap<String, Object> clockingPage(ClockingRecord cr){
		return service.selectByPage(cr);
	}
	
	/**
	 * 添加考勤记录
	 * @param cr
	 * @return
	 */
	@RequestMapping("addClocking.do")
	@ResponseBody
	public int addClocking(ClockingRecord cr) {
		int i = service.addClocking(cr);
		return i;
	}
	
	/**
	 * 模糊查询----部门
	 * @param key
	 * @param cr
	 * @return
	 */
	@RequestMapping(value = "searchClockingByLike.do",method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> searchClockingByLike(String key, ClockingRecord cr){
		return service.searchByLike(key, cr);
	}
	/**
	 * 模糊查询----时间
	 * @param key
	 * @param cr
	 * @return
	 */
	@RequestMapping(value = "searchClockingByDate.do",method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> searchClockingByDate(String key, ClockingRecord cr){
		return service.searchByDate(key, cr);
	}
	
	/**
	 * 修改考勤
	 * @param cr
	 * @return
	 */
	@RequestMapping("updateClocking.do")
	@ResponseBody
	public int updateClocking(ClockingRecord cr) {
		System.out.println("ClockingRecord" + cr);
		int i = service.updateClocking(cr);
		return i;
	}
}
