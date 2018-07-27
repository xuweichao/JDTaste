package com.jdtaste.jdtastesso.web.exception;

import lombok.Data;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.jdtastesso.common
 * @Author: xuweichao
 * @CreateTime: 2018-06-28 13:35
 * @Description: 全局异常处理
 */
@Data
public class CommonException extends RuntimeException {

    public CommonException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;


}
