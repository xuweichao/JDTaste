package com.jdtaste.service.impl;

import com.jdtaste.mybatis.domain.UserBase;
import com.jdtaste.mybatis.mapper.UserBaseMapper;
import com.jdtaste.service.IUserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.service.impl
 * @Author: xuweichao
 * @CreateTime: 2018-06-26 15:56
 * @Description: 用户基本信息功能实现类
 */
@Service
public class UserBaseServiceImpl implements IUserBaseService {
    @Autowired
    UserBaseMapper userBaseMapper;

    /**
     * 登录
     *
     * @param account
     * @return
     */
    @Override
    public UserBase userLogin(String account) {
        return userBaseMapper.getByAccount(account);
    }

    /**
     * 注册
     *
     * @param userBase
     * @return
     */
    @Override
    public int regist(UserBase userBase) {
        String phone = userBase.getPhone();
        if (findUserByAccount(phone)==null) {
            userBase.setAccount(phone);
            return userBaseMapper.insertSelective(userBase);
        } else {
            return 0;
        }
    }

    @Override
    public UserBase login(UserBase userBase) {

        return userBaseMapper.login(userBase);

    }

    @Override
    public UserBase findUserByAccount(String account) {
       return userBaseMapper.isExistAccount(account);
    }
}
