package com.gl.jxt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gl.jxt.common.annotation.*;
import com.gl.jxt.common.base.BaseController;
import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.common.page.Page;
import com.gl.jxt.domain.Order;
import com.gl.jxt.service.IOrderService;
import com.gl.jxt.web.interceptor.AdminLoginInterceptor;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Before(AdminLoginInterceptor.class)
@RequestMapping(value = "/order")
public class OrderController extends BaseController {

    @Resource
    IOrderService orderService;

    @RequestMapping(value = "/index" ,method = RequestMethod.GET)
    public String index (Model model){
        Page page = new Page(request);
        ResultModel<List<Order>> result = orderService.orderListByPage(page);
        Integer count = result.getData().size();
        model.addAttribute("result",result);
        model.addAttribute("count",count);
        return "/order";
    }

    @RequestMapping(value = "/delete/{id}" ,method = RequestMethod.GET)
    @ResponseBody
    public ResultModel delete (@PathVariable("id") int id){
        ResultModel result = orderService.delete(id);
        return result;
    }

    @RequestMapping(value = "/info/{id}" ,method = RequestMethod.GET)
    public String info(@PathVariable("id") int id ,Model model){
        Order order = orderService.findById(id);
        model.addAttribute("order",order);
        return "/order-info";
    }



}
