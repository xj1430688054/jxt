package com.gl.jxt.service;

import org.springframework.http.HttpRequest;

import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.common.page.Page;
import com.gl.jxt.domain.Member;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IMemberService {

    /**
     * 登录
     * @param member
     * @return
     */
    ResultModel login(Member member, HttpServletRequest request);

    /**
     * 注册
     * @param member
     * @param request
     * @return
     */
    ResultModel register(Member member, HttpServletRequest request);

    /**
     * 添加
     * @param member
     * @return
     */
    ResultModel add(Member member);

    Member findById(int id);

    Member findByNumber(String number);

    ResultModel update(Member member);

    ResultModel delete(int id);

    ResultModel<List<Member>> memberList();

    ResultModel<List<Member>> memberListByPage(Page page);

    /**
     * 更改学生密码
     * @param loginMember
     * @param oldPassword
     * @param newPassword
     * @return
     */
    ResultModel changePwd(Member loginMember,String oldPassword,String newPassword);

    /**
     * 编辑学生信息
     * @param loginMember
     * @param departmentName
     * @param className
     * @param contactPhone
     * @param contactEmail
     * @return
     */
    ResultModel editInfo(Member loginMember,String departmentName,String className,String contactPhone,String contactEmail);

    /**
     * 更新选取状态
     * @param loginMember
     * @param state
     * @return
     */
    ResultModel updateState(Member loginMember,Integer state);


}
