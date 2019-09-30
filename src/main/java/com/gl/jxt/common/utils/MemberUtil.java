package com.gl.jxt.common.utils;

import javax.servlet.http.HttpServletRequest;

import com.gl.jxt.common.core.Const;
import com.gl.jxt.domain.Member;

public class MemberUtil {
    public static Member getLoginMember(HttpServletRequest request){
        Member loginMember = (Member) request.getSession().getAttribute(Const.SESSION_MEMBER);
        return loginMember;
    }

    public static void setLoginMember(HttpServletRequest request,Member member){
        request.getSession().setAttribute(Const.SESSION_MEMBER,member);
    }
}