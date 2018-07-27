package com.jdtaste.mybatis.domain;

import lombok.Data;

import java.util.List;

@Data
public class ProductClassify {
    private int id;

    private String name;

    private String code;

    private int parentId;

    private Byte status;

    private boolean addItemShow=false;

    List<ProductClassify> children;



}