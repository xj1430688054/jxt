package com.gl.jxt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gl.jxt.common.annotation.*;
import com.gl.jxt.common.base.BaseController;
import com.gl.jxt.common.core.Const;
import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.domain.Admin;
import com.gl.jxt.service.IAdminService;
import com.gl.jxt.web.interceptor.AdminLoginInterceptor;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

    @Resource
    IAdminService adminService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        Admin admin = (Admin) request.getSession().getAttribute(Const.SESSION_ADMIN);
        if(admin != null){
            return "redirect:/index/";
        }
        return "/admin-login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResultModel login(Admin admin){
        ResultModel result = adminService.login(admin,request);
        return result;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @Before(AdminLoginInterceptor.class)
    public String logout(){
        request.getSession().setAttribute(Const.SESSION_ADMIN,null);
        return "redirect:/admin/login";
    }

}
