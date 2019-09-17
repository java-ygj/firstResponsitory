package com.hqyj.personel.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hqyj.personel.po.User;

public interface UserMapper {
	int deleteByPrimaryKey(Integer userId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer userId);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	/*
	 * 通过employeeNo查询User
	 */
	User getUserByemployeeNo(String employeeNo);

	/*
	 * 通过employeeNo查询Position
	 */
	List<String> searchPosition(String employeeNo);

	/*
	 * 通过employeeNo查询Power
	 */
	List<String> searchPower(String employeeNo);

	/*
	 * 通过User查询User记录 -5
	 */
	List<User> selectUserBySql(User u);

	/*
	 * 查询User记录数目 -6
	 */
	int selectCount();

	/*
	 * 假删除 -7
	 */
	int falseDeleteByUser(User user);

	/*
	 * 假删除 -8 通过部门id删除user
	 */
	int falseDeleteByDepartmentId(@Param("delId") int delId, @Param("deleteStatus") int deleteStatus);

	/* 10.通过userName和uuid查询这个人，userName就是employeeNo */
	User selectByEmployeeAndUuid(@Param("employeeNo") String userName, @Param("uuid") String uuid);

	/* 9. 添加uuid进入数据库 */
	int updateUuidByUsername(@Param("employeeNo") String userName, @Param("uuid") String uuid);

	/* 11.通过注册信息查询注册码是否正确 */
	User selectUserByRegeisteMsg(User user1);

	/* 12. 注册其实是修改 */
	int regeisteUser(@Param("password") String pwd, @Param("remark") String remake,
			@Param("employeeNo") String employeeNo, @Param("deleteStatus") String deleteStatus);

	/* 13. 删除上一次未注册信息 */
	int deleteLastRegeisteUser(String regeisteEmployeeNo);

	/* 14. 修改密码，验证账户的正确性 */
	User selectUserByNoAndPwd(@Param("employeeNo") String employeeNo, @Param("oldPassword") String oldPassword);

	/* 15. 修改密码， */
	int updatePwdByOldPwdAndNo(@Param("employeeNo") String employeeNo, @Param("newPwd") String newPwd);

	/* 16. 分部门查询用户信息 */
	List<User> searchUserByDept(@Param("start") int start, @Param("rows") int rows,
			@Param("department") String department);

	/* 17 ,分部门查询有多少用户 */
	int selectCountByDept(String department);

	/* 18. 动态sql查询user，根据这些，bengintime，endtime，department */
	List<User> selectUserByBeginTimeAndEndTimeAndDept(@Param("start") int start, @Param("rows") int rows,
			@Param("beginTime") Date beginTime, @Param("endTime") Date endTime, @Param("deptMsg") String deptMsg);

	/* 19. 动态sql查询数目，根据有无bengintime，endtime，department */
	int selectCountByBeginTimeAndEndTimeAndDept(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime,
			@Param("deptMsg") String deptMsg);
	/*20. 模糊查询user信息*/
	List<User> selectUserByKey(User u);
	/*21. 模糊查询计数*/
	int selectCountByKey(User u);

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
