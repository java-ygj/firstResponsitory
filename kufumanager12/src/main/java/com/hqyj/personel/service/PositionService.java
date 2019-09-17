package com.hqyj.personel.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.po.Position;

public interface PositionService {

	HashMap<String, Object> getPositionBySql(Position position);

	String addPositon(Position position, RedirectAttributes redirectAttributes);

	int deletePositionByIdStr(String id);

	int updatePosition(Position position);

	List<Position> getAllPosition();

	String roleFP(int userId, String positionDesc);

	List<String> selectPIdByUserId(int userId);

}
