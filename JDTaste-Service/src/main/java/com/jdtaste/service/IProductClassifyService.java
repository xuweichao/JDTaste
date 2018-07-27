package com.jdtaste.service;

import com.jdtaste.mybatis.domain.ProductClassify;
import com.jdtaste.mybatis.domain.ProductClassifySelector;

import java.util.List;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.service
 * @Author: xuweichao
 * @CreateTime: 2018-07-12 16:15
 * @Description: 产品分类
 */
public interface IProductClassifyService {
    int  saveProductClassify(ProductClassify productClassify);

    List<ProductClassify> getAllProductClassify();

    void delProductClassify(int id);

    List<ProductClassifySelector> getProductClassifyselectList();

}
