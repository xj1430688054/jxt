package com.gl.jxt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gl.jxt.common.annotation.*;
import com.gl.jxt.common.base.BaseController;
import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.domain.Category;
import com.gl.jxt.service.ICategoryService;
import com.gl.jxt.service.ITeacherService;
import com.gl.jxt.web.interceptor.AdminLoginInterceptor;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Before(AdminLoginInterceptor.class)
@RequestMapping(value = "/category")
public class CategoryController extends BaseController {

    @Resource
    ITeacherService teacherService;

    @Resource
    ICategoryService categoryService;

    @RequestMapping(value = "/index" ,method = RequestMethod.GET)
    public String index (Model model){
        ResultModel<List<Category>> result = categoryService.categoryList();
        Integer count = result.getData().size();
        model.addAttribute("result",result);
        model.addAttribute("count",count);
        return "/category";
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String add (){
        return "/category-add";
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    @ResponseBody
    public ResultModel add (Category category){
        ResultModel result = categoryService.save(category);
        return result;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResultModel delete (@PathVariable("id") int id){
        ResultModel result = categoryService.delete(id);
        return result;
    }

}
