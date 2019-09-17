package com.hqyj.personel.mapper;

import com.hqyj.personel.po.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer projectId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer projectId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}