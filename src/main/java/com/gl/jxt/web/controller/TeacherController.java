package com.gl.jxt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gl.jxt.common.annotation.*;
import com.gl.jxt.common.base.BaseController;
import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.common.page.Page;
import com.gl.jxt.domain.Category;
import com.gl.jxt.domain.Teacher;
import com.gl.jxt.service.ICategoryService;
import com.gl.jxt.service.ITeacherService;
import com.gl.jxt.web.interceptor.AdminLoginInterceptor;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Controller
@Before(AdminLoginInterceptor.class)
@RequestMapping(value = "/teacher")
public class TeacherController extends BaseController {

    @Resource
    ITeacherService teacherService;

    @Resource
    ICategoryService categoryService;

    @RequestMapping(value = "/index" ,method = RequestMethod.GET)
    public String index (Model model){
        Page page = new Page(request);
        ResultModel<List<Teacher>> result = teacherService.teacherListByPage(page);
        Integer count = result.getData().size();
        model.addAttribute("result",result);
        model.addAttribute("count",count);
        return "/teacher";
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String add (Model model){
        ResultModel<List<Category>> result = categoryService.categoryList();
        model.addAttribute("result",result);
        return "/teacher-add";
    }

    @RequestMapping(value = "/edit/{id}" ,method = RequestMethod.GET)
    public String editTeacher (@PathVariable("id") int id,Model model){
        ResultModel<List<Category>> result = categoryService.categoryList();
        model.addAttribute("result",result);
        Teacher teacher = teacherService.findById(id);
        model.addAttribute("teacher",teacher);
        return "/teacher-edit";
    }

    @RequestMapping(value = "/edit/{id}" ,method = RequestMethod.POST)
    @ResponseBody
    public ResultModel editTeacher (@PathVariable("id") int id,@RequestParam("cidArr")Integer[] cidArr,Teacher teacher){
        List<Category> categories = new ArrayList<Category>();
        for (Integer cid: cidArr) {
            Category category = new Category();
            category.setId(cid);
            categories.add(category);
        }
        teacher.setId(id);
        teacher.setCategory(categories);
        ResultModel result = teacherService.update(teacher);
        return result;
    }



    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    @ResponseBody
    public ResultModel add (@RequestParam("cidArr")Integer[] cidArr,Teacher teacher){
        List<Category> categories = new ArrayList<Category>();
        for (Integer cid: cidArr) {
            Category category = new Category();
            category.setId(cid);
            categories.add(category);
        }
        teacher.setCategory(categories);
        ResultModel result = teacherService.save(teacher);
        return result;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResultModel delete (@PathVariable("id") int id){
        ResultModel result = teacherService.delect(id);
        return result;
    }

}
