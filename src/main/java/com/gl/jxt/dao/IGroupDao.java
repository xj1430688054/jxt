package com.gl.jxt.dao;

import org.apache.ibatis.annotations.Param;

import com.gl.jxt.common.base.IBaseDao;
import com.gl.jxt.domain.Group;
import com.gl.jxt.domain.MemberOrder;

import java.util.List;

public interface IGroupDao extends IBaseDao<Group> {

    /**
     * 获取全部团队
     * @return
     */
    List<Group> groupList();

    /**
     * 根据成员id查询团队
     * @return
     * @param mid
     */
    Group findByMid (@Param("mid")int mid);

    /**
     * 保存组成员
     * @param memberOrder
     * @return
     */
    int saveGroupMember(MemberOrder memberOrder);

    /**
     * 删除全部组成员
     * @param gid
     */
    int deleteGroupMember(@Param("gid") Integer gid);

    /**
     * 根据成员id删除成员
     * @param mid
     */
    int deleteGroupMemberByMid(@Param("mid") Integer mid);

}
