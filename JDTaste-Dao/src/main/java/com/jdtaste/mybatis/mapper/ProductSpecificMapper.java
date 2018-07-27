package com.jdtaste.mybatis.mapper;

import com.jdtaste.mybatis.domain.ProductSpecific;

import java.util.List;

public interface ProductSpecificMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(ProductSpecific record);

    int updateByPrimaryKeySelective(ProductSpecific record);

    List<ProductSpecific> getAll();
}