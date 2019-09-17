package com.hqyj.personel.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.po.Position;
import com.hqyj.personel.service.PositionService;

/*角色管理
 * role=position
 * */
@Controller
public class PositionController {
	@Autowired
	private PositionService positionService;

	@RequestMapping(method = RequestMethod.GET, value = "roleFP.do")
	public String toPositionFp() {
		return "positionfp";
	}

	/**
	 * sql分页查询
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "selectPositionSql.do")
	public HashMap<String, Object> positionLoad(Position position) {

		return positionService.getPositionBySql(position);
	}

	/**
	 * 添加position
	 * 
	 * @param position
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "addPosition.do", produces = {
			"application/json;charset=UTF-8" })
	public String addPosition(Position position, RedirectAttributes redirectAttributes) {

		return positionService.addPositon(position, redirectAttributes);
	}

	/**
	 * 删除position表的记录
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "delPosition.do")
	public int deletePosition(String id) {

		return positionService.deletePositionByIdStr(id);
	}

	/**
	 * 修改position表
	 * 
	 * @param position
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "updatePosition.do")
	public int updatePosition(Position position) {

		return positionService.updatePosition(position);
	}

	/**
	 * 获取position职位信息
	 * 
	 * @return
	 */
	//分配职位相关
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "getAllPosition.do")
	public List<Position> getAllPosition() {

		return positionService.getAllPosition();
	}
	
	/**
	 *roleFP
	 * @param position
	 * @return
	 */
	//分配职位相关
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "RoleAndPositionFP.do")
	public String RoleFP(int userId,String positionDesc) {
		return positionService.roleFP(userId,positionDesc);
	}
	/**
	*getPositionByUserId
	* @param userId
	* @return
	*/
	//分配职位相关
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "getPositionByUserId.do")
	public List<String> getPositionByUserId(int userId) {
	
		return positionService.selectPIdByUserId(userId);
	}
	
}
