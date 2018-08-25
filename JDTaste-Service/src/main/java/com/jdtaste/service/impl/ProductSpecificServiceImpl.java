package com.jdtaste.service.impl;

import com.jdtaste.mybatis.domain.ProductSpecific;
import com.jdtaste.mybatis.mapper.ProductSpecificMapper;
import com.jdtaste.service.IProductSpecificService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.service.impl
 * @Author: xuweichao
 * @CreateTime: 2018-07-18 15:13
 * @Description: 商品规格功能实现类
 */
@Service
public class ProductSpecificServiceImpl implements IProductSpecificService {
    @Autowired
    ProductSpecificMapper productSpecificMapper;

   
    public List<ProductSpecific> getProductSpecificList() {
        return productSpecificMapper.getAll();
    }

   
    public int saveProductSpecific(ProductSpecific productSpecific) {
        if (productSpecific.getId() == 0) {

            return productSpecificMapper.insertSelective(productSpecific);
        } else {
            return productSpecificMapper.updateByPrimaryKeySelective(productSpecific);
        }
    }

   
    public int deleteProductSpecific(int id) {
        return productSpecificMapper.deleteByPrimaryKey(id);
    }
}
