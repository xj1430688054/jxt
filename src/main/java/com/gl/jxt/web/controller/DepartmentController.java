package com.gl.jxt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gl.jxt.common.annotation.Before;
import com.gl.jxt.common.base.BaseController;
import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.domain.Department;
import com.gl.jxt.service.IDepartmentService;
import com.gl.jxt.web.interceptor.AdminLoginInterceptor;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Before(AdminLoginInterceptor.class)
@RequestMapping(value = "/department")
public class DepartmentController extends BaseController {

    @Resource
    IDepartmentService departmentService;

    @RequestMapping(value = "/index" ,method = RequestMethod.GET)
    public String index (Model model){
        ResultModel<List<Department>> result = departmentService.departmentList();
        Integer count = result.getData().size();
        model.addAttribute("result",result);
        model.addAttribute("count",count);
        return "/department";
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String add (){
        return "/department-add";
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    @ResponseBody
    public ResultModel add (Department department){
        ResultModel result = departmentService.save(department);
        return result;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResultModel delete (@PathVariable("id") int id){
        ResultModel result = departmentService.delete(id);
        return result;
    }

}
