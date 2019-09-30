package com.gl.jxt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.jxt.common.core.Const;
import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.common.page.Page;
import com.gl.jxt.dao.ICategoryItemDao;
import com.gl.jxt.dao.IOrderDao;
import com.gl.jxt.domain.*;
import com.gl.jxt.service.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {

    @Resource
    private IOrderDao orderDao;

    @Resource
    private ICategoryItemDao categoryItemDao;

    @Resource
    private IMemberService memberService;

    @Resource
    private ITeacherService teacherService;

    @Resource
    private IGroupService groupService;

    @Resource
    private IConfigService configService;

    @Override
    @Transactional
    public ResultModel save (Order order) {
        Map<String,String> config = configService.getConfigToMap();
        if("1".equals(config.get(Const.IS_OPEN_CHOOSE))){
            return new ResultModel(-1,"选择条目已关闭");
        }
        //检查订单是否符合要求 => -1:失败
        ResultModel checkResult = checkOrder(order);
        if (checkResult.getCode() == -1){
            return checkResult;
        }
        if( order.getType() == 0 ){
            MemberOrder memberOrder = order.getMemberOrder();
            ResultModel result = saveMemberOrder(memberOrder,order);
            if( result.getCode() != 1){
                throw new RuntimeException();
            }
            return result;
        }else if(order.getType() == 1){
            /*
            保存团队用户
            遍历保存团队中所有的用户
            如果保存失败则回滚更新转态
             */
            List<MemberOrder> gMemberOrderList = (List<MemberOrder>)checkResult.getData();
            for (MemberOrder gMemberOrder : gMemberOrderList){
                ResultModel result = saveMemberOrder(gMemberOrder,order);
                if(result.getCode() != 1){
                    throw new RuntimeException();
                }
            }
            return new ResultModel(1,"保存团队订单成功");
        }
        return new ResultModel(-1,"保存订单失败");
    }

    /**
     * 删除条目，更新用户状态，更新条目分类状态
     * @param memberOrder
     */
    private void deleteMemberOrder (MemberOrder memberOrder) {
        orderDao.deleteByMid(memberOrder.getMember().getId());
        categoryItemDao.updateStateByIidAndCid(0,memberOrder.getItem().getId(),memberOrder.getCategory().getId());
        memberService.updateState(memberOrder.getMember(),0).getCode();
        teacherService.updeteStudenCount(memberOrder.getTeacher().getId(),-1).getCode();
    }

    /**
     * 保存条目，更新用户状态，更新条目分类状态
     * @param memberOrder
     * @param order
     * @return ResultModel.code = 1:保存成功;-1:保存失败
     */
    private ResultModel saveMemberOrder(MemberOrder memberOrder,Order order){
        int oc0,oc1,oc2,oc3,oc4;
        oc0 = orderDao.saveMember(memberOrder);
        order.setMemberOrder(memberOrder);
        oc1 = orderDao.save(order);
        oc2 = categoryItemDao.updateStateByIidAndCid(1,memberOrder.getItem().getId(),memberOrder.getCategory().getId());
        oc3 = memberService.updateState(memberOrder.getMember(),1).getCode();
        oc4 = teacherService.updeteStudenCount(memberOrder.getTeacher().getId(),1).getCode();
        if(oc0 == 1 && oc1 == 1 && oc2 == 1 && oc3 == 0 && oc4 == 0){
            return new ResultModel(1,"保存订单成功");
        }
        return new ResultModel(-1,"保存订单失败");
    }

    /**
     * 检查条目分类是否已被选取，教师是否可以被选取
     * @param order
     * @return
     */
    private ResultModel checkOrder(Order order){
        MemberOrder memberOrder;
        Item item;
        Category category;
        Group group;
        if(order.getType() == 0){
            memberOrder = order.getMemberOrder();
            item = memberOrder.getItem();
            category = memberOrder.getCategory();
            if (memberService.findById(memberOrder.getMember().getId()).getState() == 1){
                return new ResultModel(-1,"已选择过题目");
            }
            if (!teacherService.isCanBeChoose(memberOrder.getTeacher().getId())){
                    return new ResultModel(-1,"教师不可被选择");
            }
            if(categoryItemDao.selectCategoryItemByIidAndCid(item.getId(),category.getId())
                    .getState() != 0){
                return new ResultModel(-1,"该分类下的条目已被选取");
            }
            ResultModel result = new ResultModel(0);
            result.setData(memberOrder);
            return new ResultModel(0);
        }else if(order.getType() == 1){
            group = order.getGroup();
            if(Integer.parseInt(configService.getValue(Const.IS_OPEN_GROUP)) == 1){
                return new ResultModel(-1,"团队不开放");
            }else if( group != null){
//                group = groupService.findById(group.getId());
                List<MemberOrder> mOrderList = group.getMembers();
                List<MemberOrder> tempMOList = new ArrayList<>();
                int tCapacity = 0;
                //待优化，一次更新所有用户状态，不用循环
                Group group0 = new Group();
                group0.setId(group.getId());
                for (MemberOrder mOrder : mOrderList) {
                    if (memberService.findById(mOrder.getMember().getId()).getState() == 1){
                        return new ResultModel(-1,"已选择过题目");
                    }
                    if(teacherService.isCanBeChoose(mOrder.getTeacher().getId())){
                        tCapacity++;
                    }
                    if(categoryItemDao.selectCategoryItemByIidAndCid(mOrder.getItem().getId(),
                            mOrder.getCategory().getId())
                            .getState() != 0){
                        return new ResultModel(-1,"该分类下的条目已被选取");
                    }
                    mOrder.setGroup(group0);
                    tempMOList.add(mOrder);
                }
                if(mOrderList.size() != tCapacity){
                    return new ResultModel(-1,"教师已被选取，选取失败");
                }
                ResultModel result = new ResultModel(0);
                result.setData(tempMOList);
                return result;
            }
        }
        return new ResultModel(-1,"检查失败");
    }

    @Override
    @Transactional
    public ResultModel delete (int oid) {
        Order order = orderDao.findById(oid);
        MemberOrder memberOrder = order.getMemberOrder();
        Group group = order.getGroup();
        if(order == null){
            return new ResultModel(1,"订单已删除");
        }
        if(order.getType() == 0){
            deleteMemberOrder(memberOrder);
        }
        if(order.getType() == 1 ){
            Group group1 = groupService.findById(group.getId());
            List<MemberOrder> gMemberOrderList = group1.getMembers();
            for (MemberOrder gMemberOrder1 : gMemberOrderList){
                deleteMemberOrder(gMemberOrder1);
            }
        }
        return new ResultModel(1,"删除成功");
    }

    @Override
    public Order selectOrderByMid (int mid) {
        return orderDao.selectOrderByMid(mid);
    }

    @Override
    public Order selectOrderByGid (int gid) {
        return orderDao.selectOrderByGid(gid);
    }

    @Override
    public Order selectOrderByTid (int tid) {
        return orderDao.selectOrderByTid(tid);
    }

    @Override
    public Order selectOrderByCid (int cid) {
        return orderDao.selectOrderByCid(cid);
    }

    @Override
    public Order selectOrderByIid (int iid) {
        return orderDao.selectOrderByIid(iid);
    }

    @Override
    public Order findById (int id) {
        return orderDao.findById(id);
    }

    @Override
    public ResultModel orderList () {
        List<Order> orders = orderDao.orderList();
        ResultModel<List<Order>> result = new ResultModel<List<Order>>(0);
        result.setData(orders);
        return result;
    }

    @Override
    public ResultModel orderListByPage (Page page) {
        List<Order> orders = orderDao.orderListByPage(page);
        ResultModel<List<Order>> result = new ResultModel<List<Order>>(0,page);
        result.setData(orders);
        return result;
    }
}
