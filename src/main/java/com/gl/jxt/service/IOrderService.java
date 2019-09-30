package com.gl.jxt.service;

import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.common.page.Page;
import com.gl.jxt.domain.Order;

public interface IOrderService {

    ResultModel save(Order order);

    ResultModel delete(int oid);

    Order selectOrderByMid(int mid);

    Order selectOrderByGid(int gid);

    Order selectOrderByTid(int tid);

    Order selectOrderByCid(int cid);

    Order selectOrderByIid(int iid);

    Order findById(int id);

    ResultModel orderList();

    ResultModel orderListByPage(Page page);
}
