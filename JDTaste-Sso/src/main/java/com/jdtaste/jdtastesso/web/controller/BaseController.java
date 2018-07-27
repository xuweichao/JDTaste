package com.jdtaste.jdtastesso.web.controller;


import com.jdtaste.mybatis.domain.UserBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class BaseController {
	protected HttpServletRequest request;
    protected HttpServletResponse response;  
    protected HttpSession session;  
    protected ServletContext application;


    @ModelAttribute  
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){  
        this.request = request;  
        this.response = response;  
        this.session = request.getSession();
        this.application=request.getSession().getServletContext();
    }  


    public UserBase getAuthProfile(String account){
        return (UserBase) session.getAttribute(account);
    }

}
