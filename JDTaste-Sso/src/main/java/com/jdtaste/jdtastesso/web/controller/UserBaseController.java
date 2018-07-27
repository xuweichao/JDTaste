package com.jdtaste.jdtastesso.web.controller;

import com.jdtaste.common.domain.WrapMapper;
import com.jdtaste.common.domain.Wrapper;
import com.jdtaste.common.util.TokenUtils;
import com.jdtaste.jdtastesso.service.RedisService;
import com.jdtaste.jdtastesso.web.exception.CommonException;
import com.jdtaste.mybatis.domain.UserBase;
import com.jdtaste.service.IUserBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.jdtastesso.web.controller
 * @Author: xuweichao
 * @CreateTime: 2018-06-26 16:01
 * @Description: 单点登录
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserBaseController {
    @Autowired
    IUserBaseService userBaseService;
    @Autowired
    RedisService redisService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Wrapper sign(@RequestBody UserBase userBase) {
        log.info("用户注册参数=={}", userBase.toString());
        int result = userBaseService.regist(userBase);
        if (result == 0) {
            throw new CommonException(Wrapper.ERROR_CODE, "该账号已存在");
        }

        return WrapMapper.ok();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Wrapper login(@RequestBody UserBase userBase) {
        log.info("用户登录={}" + userBase.toString());

        if (userBaseService.findUserByAccount(userBase.getAccount()) == null) {
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "账号不存在");
        } else {
            UserBase result = null;
            result = userBaseService.login(userBase);
            if (result == null) {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "密码错误");
            } else {
                //生成token
                String accessToken = TokenUtils.createJwtToken(userBase.getAccount());
                result.setAccessToken(accessToken);
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, result);
            }
        }

    }



}
