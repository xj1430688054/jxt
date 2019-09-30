package com.gl.jxt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.dao.ICategoryDao;
import com.gl.jxt.dao.ICategoryItemDao;
import com.gl.jxt.dao.ICategoryTeacherDao;
import com.gl.jxt.dao.IDepartmentDao;
import com.gl.jxt.domain.Category;
import com.gl.jxt.domain.Order;
import com.gl.jxt.service.ICategoryService;
import com.gl.jxt.service.IOrderService;

import javax.annotation.Resource;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {

    @Resource
    private ICategoryDao categoryDao;

    @Resource
    private IDepartmentDao departmentDao;

    @Resource
    private ICategoryItemDao categoryItemDao;

    @Resource
    private ICategoryTeacherDao categoryTeacherDao;

    @Resource
    private IOrderService orderService;

    @Override
    @Transactional
    public ResultModel save (Category category) {
        if(categoryDao.findByName(category.getName()) != null){
            return new ResultModel(-1,"分类以存在");
        }
        if(category.getDepartment() != null){
            if(departmentDao.findByName(category.getDepartment().getName()) == null){
                category.setDepartment(null);
            }
        }
        if(categoryDao.save(category) == 1){
            return new ResultModel(1,"保存成功");
        }
        return new ResultModel(-1,"保存失败");
    }

    @Override
    public ResultModel update (Category category) {
        if(categoryDao.findByName(category.getName()) != null){
            return new ResultModel(-1,"分类以存在");
        }
        if(category.getDepartment() != null){
            if(departmentDao.findByName(category.getDepartment().getName()) == null){
                category.setDepartment(null);
            }
        }
        if (categoryDao.update(category) == 1){
            return new ResultModel(1,"更新成功");
        }
        return new ResultModel(1,"更新失败");
    }

    @Override
    @Transactional
    public ResultModel delete (int cid) {
        if(categoryDao.findById(cid) == null){
            return new ResultModel(-1,"分类不存在");
        }
        Order order = orderService.selectOrderByCid(cid);
        if(order != null){
            orderService.delete(order.getId());
        }
        //删除分类相连关系
        categoryItemDao.deleteItemCategoryByCid(cid);
        categoryTeacherDao.deleteTeacherCategoryByCid(cid);
        if(categoryDao.delete(cid) == 1){
            return new ResultModel(1,"删除成功");
        }
        return new ResultModel(-1,"删除失败");
    }

    @Override
    public Category findByid (int id) {
        return categoryDao.findById(id);
    }

    @Override
    public ResultModel categoryList () {
        List<Category> categories = categoryDao.categoryList();
        ResultModel<List<Category>> result = new ResultModel<List<Category>>(0);
        result.setData(categories);
        return result;
    }
}
