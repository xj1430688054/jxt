package com.gl.jxt.dao;

import com.gl.jxt.common.base.IBaseDao;
import com.gl.jxt.domain.Admin;
import com.gl.jxt.domain.Member;

public interface IAdminDao extends IBaseDao<Admin> {

    Admin login(Admin admin);

    Admin findByName(String name);

}
