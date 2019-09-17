package com.hqyj.personel.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.mapper.PositionMapper;
import com.hqyj.personel.po.Position;
import com.hqyj.personel.service.PositionService;
@Service
public class PositionServiceImpl implements PositionService {

	@Autowired
	private PositionMapper positionMapper;
	
	@Override
	public HashMap<String, Object> getPositionBySql(Position position) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 计算sql查询的起始索引
		int start = (position.getPage() - 1) * position.getRows();
		position.setStart(start);
		// 查询结果集
		List<Position> positionList = positionMapper.selectPositionBySql(position);
		// 计算position的总条数
		int total = positionMapper.selectCount();
		// 放数据
		map.put("total", total);
		map.put("rows", positionList);
		return map;
	}

	@Override
	public String addPositon(Position position, RedirectAttributes redirectAttributes) {
		
		return positionMapper.insert(position)+"";
	}

	@Override
	public int deletePositionByIdStr(String id) {
		String [] idStrs = id.split(",");
		for (String myId : idStrs) {
			int i = positionMapper.deleteByPrimaryKey(Integer.parseInt(myId));
			if(i!=1) {
				return 0;
			}
		}
		return 1;
	}

	@Override
	public int updatePosition(Position position) {
		
		return positionMapper.updateByPrimaryKey(position);
	}

	@Override
	public List<Position> getAllPosition() {
		
		return positionMapper.selectAllPosition();
	}

	@Override
	public String roleFP(int userId, String positionDesc) {
		/*先删除role信息*/
		int i = positionMapper.deleteByUserId(userId);
		String [] strPositionIds = positionDesc.split(",");
		for (String positionId : strPositionIds) {
			int j = positionMapper.insertIntoRole(userId,Integer.parseInt(positionId));
			if(j!=1) {
				return 0+"";
			}
		}
		
		return "1";
	}

	@Override
	public List<String> selectPIdByUserId(int userId) {
		
		List<Position> pList = positionMapper.selectPIdByUserId(userId);
	
		List<String> positionIdList = new ArrayList<String>();
		for (Position position : pList) {
			positionIdList.add(position.getPositionDesc());
		}
		return positionIdList;
	}

}
