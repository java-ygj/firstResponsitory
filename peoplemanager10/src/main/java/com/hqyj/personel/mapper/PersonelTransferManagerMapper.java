package com.hqyj.personel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hqyj.personel.po.PersonelTransferManager;

public interface PersonelTransferManagerMapper {
	int deleteByPrimaryKey(Integer transferId);

	/* 3. 添加一条记录 */
	int insert(PersonelTransferManager record);

	int insertSelective(PersonelTransferManager record);

	PersonelTransferManager selectByPrimaryKey(Integer transferId);

	int updateByPrimaryKeySelective(PersonelTransferManager record);

	int updateByPrimaryKey(PersonelTransferManager record);

	/* 1. 查询记录数 */
	int selectCountByKey(String myKey);

	/* 2. sql分页查询记录 */
	List<PersonelTransferManager> selectTransferRecord(PersonelTransferManager personelTransfer);
	/*4. 查询记录数*/
	int selectCountByKey();
	/*5. 模糊查询记录，sql分页查询*/

	List<PersonelTransferManager> selectTransferRecordByKey(@Param("myKey")String myKey, @Param("start")int start, @Param("rows")int rows);
	/*查询一共有多少条记录*/
	int selectCount();

}