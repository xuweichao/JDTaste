package com.jdtaste.service;

import com.jdtaste.mybatis.domain.UserBase;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.service
 * @Author: xuweichao
 * @CreateTime: 2018-06-26 15:56
 * @Description: ${Description}
 */
public interface IUserBaseService {
    UserBase userLogin(String account);

    int regist(UserBase userBase);

    UserBase login(UserBase userBase);

    UserBase findUserByAccount(String account);
}
