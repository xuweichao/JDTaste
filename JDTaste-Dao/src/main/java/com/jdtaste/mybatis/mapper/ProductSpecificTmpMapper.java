package com.jdtaste.mybatis.mapper;

import com.jdtaste.mybatis.domain.ProductSpecificTmp;

import java.util.List;

public interface ProductSpecificTmpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductSpecificTmp record);

    int insertSelective(ProductSpecificTmp record);

    ProductSpecificTmp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductSpecificTmp record);

    int updateByPrimaryKey(ProductSpecificTmp record);

    List<ProductSpecificTmp> getList();

    ProductSpecificTmp getByClassifyId(Integer classifyId);
}