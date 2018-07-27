package com.jdtaste.mybatis.domain;

import lombok.Data;

import java.util.List;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.mybatis.domain
 * @Author: xuweichao
 * @CreateTime: 2018-07-17 15:15
 * @Description: 产品分类级联选择
 */
@Data
public class ProductClassifySelector {
    private String id;
    private String label;
    private String value;
    private List<ProductClassify> children;
}
