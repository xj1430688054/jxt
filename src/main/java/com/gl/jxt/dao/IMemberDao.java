package com.gl.jxt.dao;

import org.apache.ibatis.annotations.Param;

import com.gl.jxt.common.base.IBaseDao;
import com.gl.jxt.common.page.Page;
import com.gl.jxt.domain.Department;
import com.gl.jxt.domain.Member;

import java.util.List;

/**
 * 学生DAO接口
 */

public interface IMemberDao extends IBaseDao<Member> {

    /**
     * 学生注册
     * @param member
     * @return
     */
    int register(Member member);

    /**
     * 学生登录
     * @param member
     * @return
     */
    Member login(Member member);

    /**
     * 更改密码
     * @param id
     * @param password
     */
    int changepwd(@Param("id") Integer id, @Param("password") String password);

    /**
     * 更改选取状态
     * @param id
     * @param state
     */
    int changestate(@Param("id") Integer id, @Param("state") Integer state);

    /**
     * 更改系别
     * @param nDid
     * @param did
     * @return
     */
    int changeDepartment(@Param("nDid") Integer nDid, @Param("did") Integer did);

    /**
     * @param page
     * @return
     */
    List<Member> listByPage(@Param("page") Page page);

    /**
     * 查询所有学生
     * @return
     */
    List<Member> memberList();

    /**
     * 根据系别id查询学生
     * @param id
     * @return
     */
    List<Member> memberListByDid(@Param("id") Integer id);

    /**
     * 根据学号查询学生
     * @param number
     * @return
     */
    Member findByNumber(@Param("number") String number);

    /**
     * 根据学生选取状态查询学生
     * @param state
     * @return
     */
    List<Member> findByState(@Param("state") Integer state);

    /**
     * 根据学号列表查询学生
     * @param members
     * @return
     */
    List<Member> findByNumberList(List<Member> members);

}
