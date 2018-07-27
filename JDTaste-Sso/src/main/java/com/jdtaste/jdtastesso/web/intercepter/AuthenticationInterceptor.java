package com.jdtaste.jdtastesso.web.intercepter;

import com.jdtaste.common.util.TokenUtils;
import com.jdtaste.jdtastesso.web.exception.CommonException;
import com.jdtaste.jdtastesso.web.intercepter.auth.CurrentUserConstants;
import com.jdtaste.jdtastesso.web.intercepter.auth.LoginRequired;
import com.jdtaste.mybatis.domain.UserBase;
import com.jdtaste.service.IUserBaseService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.net.InetAddress;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.jdtastesso.web.intercepter
 * @Author: xuweichao
 * @CreateTime: 2018-07-04 09:50
 * @Description: 拦截器
 */
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {
    public final static String ACCESS_TOKEN = "accessToken";
    @Resource
    IUserBaseService userBaseService;

    // 在业务处理器处理请求之前被调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String ip = getIpAddr(request);
        log.info("用户ip==>>" + ip);
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断接口是否需要登录
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);

        // 有 @LoginRequired 注解，需要认证
        if (methodAnnotation != null) {
            // 判断是否存在令牌信息，如果存在，则允许登录
            String accessToken = request.getHeader("Authorization");


            if (null == accessToken) {
                throw new CommonException(401, "无token，请重新登录");
            } else {
                // 从Redis 中查看 token 是否过期
                Claims claims;
                try {
                    claims = TokenUtils.parseJWT(accessToken);
                } catch (ExpiredJwtException e) {
                    response.setStatus(401);
                    throw new CommonException(401, "token失效，请重新登录");
                } catch (SignatureException se) {
                    response.setStatus(401);
                    throw new CommonException(401, "token令牌错误");
                }

                String userName = claims.getId();
                UserBase user = userBaseService.findUserByAccount(userName);
                if (user == null) {
                    response.setStatus(401);
                    throw new CommonException(401, "用户不存在，请重新登录");
                }
                // 当前登录用户@CurrentUser
                request.setAttribute(CurrentUserConstants.CURRENT_USER, user);
                return true;
            }

        } else {//不需要登录可请求
            return true;
        }
    }

    // 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    // 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }


    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
            }
        }
        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }

}
