package com.jdtaste.mybatis.mapper;

import com.jdtaste.mybatis.domain.UserBase;

public interface UserBaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserBase record);

    int insertSelective(UserBase record);

    UserBase selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserBase record);

    int updateByPrimaryKey(UserBase record);

    UserBase getByAccount(String account);

    UserBase isExistAccount(String phone);

    UserBase login(UserBase userBase);
}