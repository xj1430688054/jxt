package com.gl.jxt.dao;

import org.apache.ibatis.annotations.Param;

import com.gl.jxt.common.base.IBaseDao;
import com.gl.jxt.common.page.Page;
import com.gl.jxt.domain.MemberOrder;
import com.gl.jxt.domain.Order;

import java.util.List;

public interface IOrderDao extends IBaseDao<Order> {

    /**
     * 查询所有订单
     * @return
     */
    List<Order> orderList();

    /**
     * @param memberOrder
     * @return
     */
    int saveMember(MemberOrder memberOrder);

    /**
     * 根据用户id删除
     * @param mid
     * @return
     */
    int deleteByMid(@Param("mid") int mid);

    /**
     * @param memberOrder
     * @return
     */
    int updateMember(MemberOrder memberOrder);

    /**
     * 根据学生id获取订单
     * @param mid
     * @return
     */
    Order selectOrderByMid(@Param("mid") Integer mid);

    /**
     * 根据教师id获取订单
     * @param tid
     * @return
     */
    Order selectOrderByTid(@Param("tid") Integer tid);

    /**
     * 根据分类id获取订单
     * @param cid
     * @return
     */
    Order selectOrderByCid(@Param("cid") Integer cid);

    /**
     * 根据条目id获取订单
     * @param iid
     * @return
     */
    Order selectOrderByIid(@Param("iid") Integer iid);

    /**
     * 根据团队id获取订单
     * @param gid
     * @return
     */
    Order selectOrderByGid(@Param("gid") Integer gid);

    List<Order> orderListByPage (Page page);
}
