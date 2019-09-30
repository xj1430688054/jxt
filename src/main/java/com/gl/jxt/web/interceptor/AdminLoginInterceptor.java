package com.gl.jxt.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gl.jxt.common.core.Const;
import com.gl.jxt.domain.Admin;

public class AdminLoginInterceptor  implements TInterceptor{

    @Override
    public boolean interceptor (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        try {
            Admin loginAdmin  = (Admin) httpServletRequest.getSession().getAttribute(Const.SESSION_ADMIN);
            if (loginAdmin == null) {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/admin/login");
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
