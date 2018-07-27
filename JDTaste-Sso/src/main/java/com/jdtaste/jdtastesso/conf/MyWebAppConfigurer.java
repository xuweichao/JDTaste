package com.jdtaste.jdtastesso.conf;

import com.jdtaste.jdtastesso.web.filter.XssFilter;
import com.jdtaste.jdtastesso.web.intercepter.AuthenticationInterceptor;
import com.jdtaste.jdtastesso.web.intercepter.auth.CurrentUserMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;
import java.util.List;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.jdtastesso.conf
 * @Author: xuweichao
 * @CreateTime: 2018-07-04 10:03
 * @Description: 配置URLInterceptor拦截器，以及拦截路径
 */
@EnableWebMvc
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/*/*");
        super.addInterceptors(registry);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserMethodArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }

    @Bean
    public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
        return new CurrentUserMethodArgumentResolver();
    }

    /**
     * 解决 拦截器中注入bean 失败情况出现
     * addArgumentResolvers方法中 添加
     * argumentResolvers.add(currentUserMethodArgumentResolver());
     */
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }


    /**
     * 创建一个bean
     *
     * @return
     */
    @Bean(name = "xssFilter")
    public Filter sessionFilter() {
        return new XssFilter();
    }



}
