package com.gl.jxt.service;

import java.util.List;

import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.domain.Group;

public interface IGroupService {

    /**
     * 保存团队订单
     * 失败删除团队
     * @param group
     * @return
     */
    ResultModel saveGroupOrder(Group group);

    /**
     * 根据学生id删除团队学生关系
     * @param id
     * @return
     */
    ResultModel deleteGroupMemberByMid(int id);

    Group findById(int gid);

    /**
     * 根据学生id查找团队
     * @param mid
     * @return
     */
    Group findByMid (int mid);

    /**
     * 保存团队
     * @param group
     * @return
     */
    ResultModel save(Group group);

    ResultModel delete(Integer gid);

    ResultModel update(Group group);

    /**
     * 获的全部团队
     * @return
     */
    ResultModel<List<Group>> groupList();
}
