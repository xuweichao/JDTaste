package com.jdtaste.jdtastesso.web.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.jdtastesso.web.listener
 * @Author: xuweichao
 * @CreateTime: 2018-07-05 14:51
 * @Description: 全局监听器
 */
@Slf4j
@WebListener
public class MyContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("=================MyContextListener 初始化...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("=================MyContextListener 销毁...");
    }

}