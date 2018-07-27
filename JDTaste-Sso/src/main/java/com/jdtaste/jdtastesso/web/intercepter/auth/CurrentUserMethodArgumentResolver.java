package com.jdtaste.jdtastesso.web.intercepter.auth;

import com.jdtaste.mybatis.domain.UserBase;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.jdtastesso.web.intercepter.auth
 * @Author: xuweichao
 * @CreateTime: 2018-07-04 15:42
 * @Description: 自定义参数解析器
 * 增加方法注入，将含有 @CurrentUser 注解的方法参数注入当前登录用户
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    /*
     * supportsParameter：用于判定是否需要处理该参数分解，返回true为需要，并会去调用下面的方法resolveArgument。
     *resolveArgument：真正用于处理参数分解的方法，返回的Object就是controller方法上的形参对象。
     *
     * */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(UserBase.class)//判断是否能转成UserBase 类型
                && parameter.hasParameterAnnotation(CurrentUser.class);//是否有CurrentUser注解
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        UserBase user = (UserBase) webRequest.getAttribute(CurrentUserConstants.CURRENT_USER, RequestAttributes.SCOPE_REQUEST);
        if (user != null) {
            return user;
        }
        throw new MissingServletRequestPartException(CurrentUserConstants.CURRENT_USER);
    }
}
