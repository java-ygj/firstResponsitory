package com.hqyj.personel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hqyj.personel.po.Position;

public interface PositionMapper {
	/*4. 删除一条记录,通过position_id*/
    int deleteByPrimaryKey(Integer positionId);
    /*3. 添加一条记录*/
    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer positionId);

    int updateByPrimaryKeySelective(Position record);
    /*5. 修改，position通过position_id*/
    int updateByPrimaryKey(Position record);
    
    
    /*1. 计数，计算有多少条记录*/
	int selectCount();
	/*2. 通过position里面的rows和start计算*/
	List<Position> selectPositionBySql(Position position);
	/*5. 查询所有的position信息*/
	List<Position> selectAllPosition();
	/*6.删除*/
	int deleteByUserId(int userId);
	/*7. 添加role信息*/
	int insertIntoRole(@Param("userId")int userId,@Param("positionId")int positionId);
	/*8. 查询positionid通过userid*/
	List<Position> selectPIdByUserId(int userId);
}