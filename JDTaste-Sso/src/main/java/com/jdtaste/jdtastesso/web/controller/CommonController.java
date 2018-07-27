package com.jdtaste.jdtastesso.web.controller;

import com.jdtaste.common.domain.WrapMapper;
import com.jdtaste.common.domain.Wrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.jdtastesso.web.controller
 * @Author: xuweichao
 * @CreateTime: 2018-07-02 17:21
 * @Description: 通用接口
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    @RequestMapping(value = "getVerifyCode")
    public Wrapper<?> getVerifyCode(String phone) {

        int verifyCode = new Random().nextInt(999999)%900000+100000 ;

        return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, verifyCode);
    }




}
