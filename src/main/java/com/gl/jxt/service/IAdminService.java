package com.gl.jxt.service;

import javax.servlet.http.HttpServletRequest;

import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.domain.Admin;
import com.gl.jxt.domain.Member;

public interface IAdminService {


    ResultModel login(Admin admin, HttpServletRequest request);

    Admin findById(int id);

    Admin findByName(String name);

}
