package com.jdtaste.jdtastesso.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.jdtastesso.common
 * @Author: xuweichao
 * @CreateTime: 2018-06-28 13:59
 * @Description: 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {
    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(HttpServletRequest req,Exception ex) {
        Map map = new HashMap();
        map.put("code", 100);
        map.put("message", "服务器内部错误");
        map.put("url", req.getRequestURL());
        map.put("params", req.getParameterMap());
        log.error("发生未处理的异常={}",ex.getMessage(),ex);
        return map;
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ExceptionHandler(value = CommonException.class)
    public Map myErrorHandler(HttpServletRequest req, CommonException ex) {
        Map map = new HashMap();
        map.put("code", ex.getCode());
        map.put("message", ex.getMsg());
        map.put("url", req.getRequestURL());
        map.put("params", req.getParameterMap());
        return map;
    }

}
