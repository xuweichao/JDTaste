package com.jdtaste.service;

import com.jdtaste.mybatis.domain.ProductSpecificTmp;

import java.util.List;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.service
 * @Author: xuweichao
 * @CreateTime: 2018-07-20 10:03
 * @Description: ${Description}
 */
public interface IProductSpecificTmpService {
    int saveProductSpecificTmp(ProductSpecificTmp productSpecificTmp);

    List<ProductSpecificTmp> getProductSpecificTmpList();

    int deleteProductSpecificTmp(int id);
}
