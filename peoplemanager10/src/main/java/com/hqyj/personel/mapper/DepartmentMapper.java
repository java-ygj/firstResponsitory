package com.hqyj.personel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hqyj.personel.po.Department;
import com.hqyj.personel.po.User;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer departmentId);
    /*3. 添加一条部门记录*/
    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer departmentId);
    /*4. 修改部门名字，用自动sql*/
    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    /*1. 查询数量*/
	int selectCount();
	/*2. 查询部门信息，分页查询*/
	List<User> selectDepartmentBySql(Department dpt);
	
	/*5. 假删除部门*/
	int falseDeleteByDepartmentId(@Param("delId")int delId, @Param("deleteStatus")int deleteStatus);
	/*6. 查询所有的部门*/
	List<Department> selectAllDepartments();
}