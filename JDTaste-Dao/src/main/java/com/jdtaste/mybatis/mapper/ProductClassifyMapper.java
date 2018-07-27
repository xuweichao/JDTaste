package com.jdtaste.mybatis.mapper;

import com.jdtaste.mybatis.domain.ProductClassify;
import com.jdtaste.mybatis.domain.ProductClassifySelector;

import java.util.List;

public interface ProductClassifyMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(ProductClassify record);

    int selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductClassify record);

    List<ProductClassify> selectMainItem();

    void deleteByParentId(int id);

    List<ProductClassifySelector> getSelectorList();

}