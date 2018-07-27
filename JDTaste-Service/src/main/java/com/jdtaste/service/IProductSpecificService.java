package com.jdtaste.service;

import com.jdtaste.mybatis.domain.ProductSpecific;

import java.util.List;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.service
 * @Author: xuweichao
 * @CreateTime: 2018-07-18 15:12
 * @Description: ${Description}
 */
public interface IProductSpecificService {
    List<ProductSpecific> getProductSpecificList();

    int saveProductSpecific(ProductSpecific productSpecific);

    int deleteProductSpecific(int id);
}
