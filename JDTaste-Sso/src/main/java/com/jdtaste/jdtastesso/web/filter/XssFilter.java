package com.jdtaste.jdtastesso.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.jdtastesso.web.filter
 * @Author: xuweichao
 * @CreateTime: 2018-07-05 14:33
 * @Description: xss 过滤器
 */
public class XssFilter implements Filter {

    FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        //对请求进行拦截,防xss处理
        chain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest) request), response);

    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
