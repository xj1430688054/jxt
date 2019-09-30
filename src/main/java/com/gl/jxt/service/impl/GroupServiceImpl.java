package com.gl.jxt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.jxt.common.core.Const;
import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.dao.IGroupDao;
import com.gl.jxt.dao.IMemberDao;
import com.gl.jxt.domain.Group;
import com.gl.jxt.domain.Member;
import com.gl.jxt.domain.MemberOrder;
import com.gl.jxt.domain.Order;
import com.gl.jxt.service.IConfigService;
import com.gl.jxt.service.IGroupService;
import com.gl.jxt.service.IOrderService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service("groupService")
public class GroupServiceImpl implements IGroupService {

    @Resource
    private IGroupDao groupDao;

    @Resource
    private IMemberDao memberDao;

    @Resource
    private IOrderService orderService;

    @Resource
    private IConfigService configService;

    /**
     * 保存团队订单
     * 失败删除团队
     * @param group
     * @return
     */
    @Override
    @Transactional
    public ResultModel saveGroupOrder(Group group){
        if(Integer.parseInt(configService.getValue(Const.IS_OPEN_GROUP)) == 1){
            return new ResultModel(-1,"团队不开放");
        }
        int oc0,oc1;
        Order order = new Order();
        order.setType(1);
        ResultModel gresult = save(group);
        oc0 = gresult.getCode();
        if (oc0 == -1){
            return gresult;
        }
        order.setGroup(group);
        ResultModel oresult = orderService.save(order);
        oc1 = oresult.getCode();
        if(oc0 == 1 && oc1 == 1){
            return new ResultModel(1,"操作成功");
        }else {
            //保存失败回滚数据
            delete(group.getId());
            return oresult;
        }
    }

    /**
     * 根据成员id删除团队成员，如果队长被删除则删除整个组
     * @param id
     * @return
     */
    @Override
    @Transactional
    public ResultModel deleteGroupMemberByMid (int id) {
        Group group = groupDao.findByMid(id);
        if (group != null){
            if (group.getCaptainId() == id){
                groupDao.deleteGroupMember(group.getId());
                groupDao.delete(group.getId());
                return new ResultModel(1,"操作成功");
            }else {
                groupDao.deleteGroupMemberByMid(id);
                return new ResultModel(1,"操作成功");
            }
        }
        return new ResultModel(-1,"操作失败");
    }

    @Override
    public Group findByMid (int id) {
        return groupDao.findByMid(id);
    }

    @Override
    public Group findById (int gid) {
        return groupDao.findById(gid);
    }

    /**
     * 保存团队，校验团队中的学生学号是否存在&&学生是否已选择条目
     * 校验团队人数是否超出规定人数
     * @param group
     * @return
     */
    @Override
    @Transactional
    public ResultModel save (Group group) {
        List<MemberOrder> members = group.getMembers();
        List<Member> tempList = new LinkedList<>();
        //校验学生学号是否存在&&学生是否已选择条目
        for (MemberOrder member : members ) {
            tempList.add(member.getMember());
        }
        List<Member> tMemberList = memberDao.findByNumberList(tempList);
        if(tMemberList.size() != members.size()){
            return new ResultModel(-1,"成员错误");
        }
        for (Member member : tMemberList) {
            if(member.getState() == 1){
                return new ResultModel(-1,"成员错误");
            }
        }
        if (tMemberList.size() < 2){
            return new ResultModel(-1,"团队人数过少，创建失败");
        }
        //如果团队人数超出规定人数，则保存失败
        if(tMemberList.size() > Integer.parseInt(configService.getValue(Const.MEMBER_MAX_COUNT))){
            return new ResultModel(-1,"团队人数过多，创建失败");
        }
        group.setMembers(members);
        if(groupDao.save(group) == 1){
//            for (MemberOrder gMemberOrder : group.getMembers()){
//                gMemberOrder.setGroup(group);
//            }
            return new ResultModel(1,"创建成功");
        }
        return new ResultModel(-1,"创建失败");
    }

    /**
     * 根据组id删除组
     * 删除成员与组关系
     * 删除与组相关联的订单
     * @param gid
     * @return
     */
    @Override
    @Transactional
    public ResultModel delete (Integer gid) {
        Group group = groupDao.findById(gid);
        if (group != null){
            groupDao.deleteGroupMember(group.getId());
            Order order = orderService.selectOrderByGid(gid);
            if(order != null){
                orderService.delete(order.getId());
            }
            if(groupDao.delete(group.getId()) == 1){
                return new ResultModel(1,"删除操作成功");
            }
        }
        return new ResultModel(-1,"操作失败");
    }

    /**
     * 不提供
     * @param group
     * @return
     */
    @Override
    public ResultModel update (Group group) {
        return null;
    }

    @Override
    public ResultModel<List<Group>> groupList () {
        List<Group> groups = groupDao.groupList();
        ResultModel result = new ResultModel<List<Group>>(0);
        return result;
    }
}
