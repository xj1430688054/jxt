package com.gl.jxt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.common.page.Page;
import com.gl.jxt.common.utils.StringUtils;
import com.gl.jxt.dao.ICategoryDao;
import com.gl.jxt.dao.ICategoryTeacherDao;
import com.gl.jxt.dao.ITeacherDao;
import com.gl.jxt.domain.Category;
import com.gl.jxt.domain.Order;
import com.gl.jxt.domain.Teacher;
import com.gl.jxt.service.IOrderService;
import com.gl.jxt.service.ITeacherService;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements ITeacherService {

    @Resource
    private ICategoryDao categoryDao;

    @Resource
    private ITeacherDao teacherDao;

    @Resource
    private ICategoryTeacherDao categoryTeacherDao;

    @Resource
    private IOrderService orderService;
    
    @Override
    @Transactional
    public ResultModel save (Teacher teacher) {
        if(StringUtils.isEmpty(teacher.getName())){
            return new ResultModel(-1,"姓名不能为空");
        }
        if(teacher.getCapacity() < 0){
            return new ResultModel(-1,"容量不可小于0");
        }else{
            teacher.setStudentCount(teacher.getCapacity());
        }
        List<Category> teacherCategories = teacher.getCategory();
        List<Category> categories = forCategory(teacherCategories);
        teacher.setCategory(categories);
        if(teacherDao.save(teacher) == 1){
            //保存教师分类关系
            for (Category c : categories) {
                categoryTeacherDao.saveTeacherCategory(teacher.getId(),c.getId());
            }
            return new ResultModel(0,"保存成功");
        }
        return new ResultModel(-1,"保存失败");
    }

    /*
    当教师更新时，所对应的订单不会改变
     */
    @Override
    @Transactional
    public ResultModel update (Teacher teacher) {
        if(teacher.getCapacity() < 0 && teacher.getCapacity() < teacher.getStudentCount()){
            return new ResultModel(-1,"容量错误");
        }
        List<Category> teacherCategories = teacher.getCategory();
        List<Category> categories = forCategory(teacherCategories);
        teacher.setCategory(categories);
        if(teacherDao.update(teacher) == 1){
            //维持教师分类关系
            categoryTeacherDao.deleteTeacherCategoryByTid(teacher.getId());
            for (Category c : categories) {
                categoryTeacherDao.saveTeacherCategory(teacher.getId(),c.getId());
            }
            return new ResultModel(1,"更新成功");
        }
        return new ResultModel(-1,"更新失败");
    }

    /**
     * 遍历保存分类集合
     * @param teacherCategories
     */
    private List<Category> forCategory (List<Category> teacherCategories) {
        List<Category> categories = categoryDao.categoryList();
        List<Category> tureCategories = new LinkedList<Category>();
        for (Category teacherCategory: teacherCategories) {
            for (Category category : categories) {
                if(category.getId() == teacherCategory.getId()){
                    tureCategories.add(category);
                }
            }
        }
        return tureCategories;
    }

    /**
     * 删除教师
     * 删除教师对应的定单
     * 删除教师分类关系
     * @param id
     * @return
     */
    @Override
    @Transactional
    public ResultModel delect (int id) {
        Teacher teacher = teacherDao.findById(id);
        if(teacher == null){
            return new ResultModel(-1,"教师不存在");
        }
        Order order = orderService.selectOrderByTid(id);
        if(order != null){
            orderService.delete(order.getId());
        }
        //删除教师分类关系
        categoryTeacherDao.deleteTeacherCategoryByTid(id);
        teacherDao.delete(id);
        return new ResultModel(0,"操作成功");
    }

    @Override
    public ResultModel teacherList () {
        List<Teacher> teachers = teacherDao.teacherList();
        ResultModel result = new ResultModel(0);
        result.setData(teachers);
        return result;
    }

    @Override
    public ResultModel teacherListByPage (Page page) {
        List<Teacher> teachers = teacherDao.teacherListByPage(page);
        ResultModel result = new ResultModel(0,page);
        result.setData(teachers);
        return result;
    }


    @Override
    public boolean isCanBeChoose(int tid){
        Teacher teacher = teacherDao.findById(tid);
        if(teacher == null){
            return false;
        }
        int tcount = teacher.getStudentCount();
        if (tcount > 0){
            return true;
        }
        return false;
    }

    /**
     * 更新教师学生数量
     * 如果更新的学生数量大于所剩容量则更新失败
     * @param id
     * @param count
     * @return
     */
    @Override
    public ResultModel updeteStudenCount (int id, int count) {
        Teacher teacher = teacherDao.findById(id);
        if(teacher == null){
            return new ResultModel(-1,"教师不存在");
        }
        int tcount = teacher.getStudentCount();
        int capacity = teacher.getCapacity();
        if((capacity - tcount) < count){
            return new ResultModel(-1,"教师的学生数量过多");
        }else {
            teacherDao.updeteStudenCount(count,id);
            return new ResultModel(0,"操作成功");
        }
    }

    @Override
    public Teacher findById (int tid) {
        return teacherDao.findById(tid);
    }
}
