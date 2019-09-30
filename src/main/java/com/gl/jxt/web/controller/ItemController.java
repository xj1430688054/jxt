package com.gl.jxt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gl.jxt.common.annotation.*;
import com.gl.jxt.common.base.BaseController;
import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.common.page.Page;
import com.gl.jxt.domain.Category;
import com.gl.jxt.domain.CategoryItem;
import com.gl.jxt.domain.Item;
import com.gl.jxt.service.ICategoryService;
import com.gl.jxt.service.IItemService;
import com.gl.jxt.web.interceptor.AdminLoginInterceptor;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@Before(AdminLoginInterceptor.class)
@RequestMapping(value = "/item")
public class ItemController extends BaseController {

    @Resource
    IItemService itemService;

    @Resource
    ICategoryService categoryService;

    @RequestMapping(value = "/index" ,method = RequestMethod.GET)
    public String index (Model model){
        Page page = new Page(request);
        ResultModel<List<Item>> result = itemService.itemListByPage(page);
        Integer count = result.getData().size();
        model.addAttribute("result",result);
        model.addAttribute("count",count);
        return "/item";
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String add (Model model){
        ResultModel<List<Category>> result = categoryService.categoryList();
        model.addAttribute("result",result);
        return "/item-add";
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    @ResponseBody
    public ResultModel add (@RequestParam("cidArr")Integer[] cidArr, Item item){
        List<CategoryItem> categoryItems = new ArrayList<CategoryItem>();
        for (Integer cid: cidArr) {
            CategoryItem cI = new CategoryItem();
            cI.setId(cid);
            categoryItems.add(cI);
        }
        item.setCategories(categoryItems);
        ResultModel result = itemService.save(item);
        return result;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResultModel delete (@PathVariable("id") int id){
        ResultModel result = itemService.delete(id);
        return result;
    }

    @RequestMapping(value = "/edit/{id}" ,method = RequestMethod.GET)
    public String editTeacher (@PathVariable("id") int id,Model model){
        ResultModel<List<Category>> result = categoryService.categoryList();
        model.addAttribute("result",result);
        Item item = itemService.findById(id);
        model.addAttribute("item",item);
        return "/item-edit";
    }

    @RequestMapping(value = "/edit/{id}" ,method = RequestMethod.POST)
    @ResponseBody
    public ResultModel editTeacher (@PathVariable("id") int id,@RequestParam("cidArr")Integer[] cidArr,Item item){
        List<CategoryItem> categoryItems = new ArrayList<CategoryItem>();
        for (Integer cid: cidArr) {
            CategoryItem cI = new CategoryItem();
            cI.setId(cid);
            categoryItems.add(cI);
        }
        item.setCategories(categoryItems);
        ResultModel result = itemService.update(item);
        return result;
    }

}
