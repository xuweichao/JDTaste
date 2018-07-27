package com.jdtaste.service.impl;

import com.jdtaste.mybatis.domain.ProductClassify;
import com.jdtaste.mybatis.domain.ProductClassifySelector;
import com.jdtaste.mybatis.mapper.ProductClassifyMapper;
import com.jdtaste.service.IProductClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.service.impl
 * @Author: xuweichao
 * @CreateTime: 2018-07-12 16:16
 * @Description:
 */
@Service
public class ProductClassifyServiceimpl implements IProductClassifyService {
    @Autowired
    ProductClassifyMapper productClassifyMapper;

    @Override
    public int saveProductClassify(ProductClassify productClassify) {
        if (productClassify.getId() == 0) {
            return productClassifyMapper.insertSelective(productClassify);
        } else {
            return productClassifyMapper.updateByPrimaryKeySelective(productClassify);
        }
    }

    @Override
    public List<ProductClassify> getAllProductClassify() {
        return productClassifyMapper.selectMainItem();
    }

    @Override
    public void delProductClassify(int id) {
        if (productClassifyMapper.selectByPrimaryKey(id) == 0) {//主分类
            productClassifyMapper.deleteByParentId(id);
            productClassifyMapper.deleteByPrimaryKey(id);
        }else{//子分类
            productClassifyMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<ProductClassifySelector> getProductClassifyselectList() {
        return productClassifyMapper.getSelectorList();
    }
}
