package com.gl.jxt.service.impl;

import org.springframework.stereotype.Service;

import com.gl.jxt.common.core.Const;
import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.common.utils.Md5Util;
import com.gl.jxt.dao.IAdminDao;
import com.gl.jxt.domain.Admin;
import com.gl.jxt.service.IAdminService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service(value = "adminService")
public class AdminServiceImpl implements IAdminService {

    @Resource
    IAdminDao adminDao;

    @Override
    public ResultModel login (Admin admin , HttpServletRequest request) {
        String password = admin.getPassword();
        admin.setPassword(Md5Util.getMD5Code(password));
        Admin findAdmin = adminDao.login(admin);
        if (findAdmin != null){
            findAdmin = this.findByName(admin.getName());
            request.getSession().setAttribute(Const.SESSION_ADMIN,admin);
            return new ResultModel(3,"登录成功",request.getServletContext().getContextPath()+"/index/");
        }
        return new ResultModel(-1,"用户名或密码错误");
    }

    @Override
    public Admin findById (int id) {
        return adminDao.findById(id);
    }

    @Override
    public Admin findByName (String name) {
        return adminDao.findByName(name);
    }
}
