package com.hqyj.personel.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.personel.mapper.PersonelTransferManagerMapper;
import com.hqyj.personel.mapper.PositionMapper;
import com.hqyj.personel.mapper.UserMapper;
import com.hqyj.personel.mapper.UserPositionMapper;
import com.hqyj.personel.po.PersonelTransferManager;
import com.hqyj.personel.po.Position;
import com.hqyj.personel.po.User;
import com.hqyj.personel.po.UserPosition;
import com.hqyj.personel.service.PositionTransferService;
@Service
public class PositionTransferServiceImpl implements PositionTransferService {

	@Autowired
	private PersonelTransferManagerMapper transferMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserPositionMapper userPositionMapper;
	@Autowired
	private PositionMapper positionMapper;
	@Override
	public HashMap<String, Object> loadPositionTransfer(PersonelTransferManager personelTransfer) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int start = (personelTransfer.getPage()-1)*personelTransfer.getRows();
		personelTransfer.setStart(start);
		List<PersonelTransferManager> positionTransferList = transferMapper.selectTransferRecord(personelTransfer);
		int total = transferMapper.selectCount();
		map.put("total", total);
		map.put("rows", positionTransferList);
		
		return map;
	}

	@Override
	public String addPositionTransfer(PersonelTransferManager pTM, String positionDesc) {
		User user = userMapper.getUserByemployeeNo(pTM.getEmployeeNo());
		/*判斷這個員工是否存在*/
		if(user!=null) {
			/*1.查询职位，旧职位*/
			List<String> oldPositions = userMapper.searchPosition(pTM.getEmployeeNo());
			System.out.println(oldPositions+"oldPositions");
			/*2. 新职位信息*/
			List<String> positionList = new ArrayList<String>();
			UserPosition userPosition = new UserPosition();
			String [] positionIds = positionDesc.split(",");
			for (String str: positionIds) {
				 Position position = positionMapper.selectByPrimaryKey(Integer.parseInt(str));
				 positionList.add(position.getPositionDesc());
				 /*修改职位，userPosition表*/
				 userPosition.setUserId(user.getUserId());
				 userPosition.setPositionId(Integer.parseInt(str));
				 userPositionMapper.insert(userPosition);
			}
			/*添加一条人事调配信息*/
			pTM.setEmployeeNo(user.getEmployeeNo());//employno
			String oldPositionStr = "";
			for (String string : oldPositions) {//old_position
				oldPositionStr+=string;
			}
			pTM.setOldPosition(oldPositionStr);
			String newPositionStr = "";
			for(String str:positionList) {//new_position
				newPositionStr+=str;
			}
			pTM.setNewPosition(newPositionStr);
			transferMapper.insert(pTM);
			return "1";
		}else {
			return "员工不存在";
		}
	}
	@Override
	public HashMap<String, Object> searchTransferrByKey(String key, PersonelTransferManager ptm) {
		String myKey = "%"+key+"%";
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int start = (ptm.getPage()-1)*ptm.getRows();
		ptm.setStart(start);
		List<PersonelTransferManager> positionTransferList = transferMapper.selectTransferRecordByKey(myKey,start,ptm.getRows());
		int total = transferMapper.selectCountByKey(myKey);
		map.put("total", total);
		map.put("rows", positionTransferList);
		
		return map;
		
	}
}
