package com.jdtaste.service.impl;

import com.jdtaste.mybatis.domain.ProductSpecificTmp;
import com.jdtaste.mybatis.mapper.ProductSpecificTmpMapper;
import com.jdtaste.service.IProductSpecificTmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.service.impl
 * @Author: xuweichao
 * @CreateTime: 2018-07-20 10:03
 * @Description: 规格模板
 */
@Service
public class ProductSpecificTmpServiceImpl implements IProductSpecificTmpService {
    @Autowired
    ProductSpecificTmpMapper productSpecificTmpMapper;

    
    public int saveProductSpecificTmp(ProductSpecificTmp productSpecificTmp) {
        if (productSpecificTmp.getId() == 0&&
                productSpecificTmpMapper.getByClassifyId(productSpecificTmp.getClassifyId())==null) {
            return productSpecificTmpMapper.insertSelective(productSpecificTmp);
        } else {
            return productSpecificTmpMapper.updateByPrimaryKeySelective(productSpecificTmp);
        }
    }

    
    public List<ProductSpecificTmp> getProductSpecificTmpList() {

        return productSpecificTmpMapper.getList();
    }

    
    public int deleteProductSpecificTmp(int id) {
        return productSpecificTmpMapper.deleteByPrimaryKey(id);
    }
}
