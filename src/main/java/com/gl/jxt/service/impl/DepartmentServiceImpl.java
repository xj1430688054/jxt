package com.gl.jxt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.dao.ICategoryDao;
import com.gl.jxt.dao.IDepartmentDao;
import com.gl.jxt.dao.IMemberDao;
import com.gl.jxt.domain.Department;
import com.gl.jxt.service.IDepartmentService;

import javax.annotation.Resource;
import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements IDepartmentService {

    @Resource
    IDepartmentDao departmentDao;

    @Resource
    IMemberDao memberDao;

    @Resource
    ICategoryDao categoryDao;

    @Override
    @Transactional
    public ResultModel save (Department department) {
        if(departmentDao.findByName(department.getName()) != null){
            return new ResultModel(-1,"系别以存在");
        }
        if(departmentDao.save(department) == 1){
            return new ResultModel(1,"保存成功");
        }
        return new ResultModel(-1,"保存失败");
    }

    @Override
    public ResultModel update (Department department) {
        return null;
    }

    @Override
    @Transactional
    public ResultModel delete (int id) {
        if(departmentDao.findById(id) == null){
            return new ResultModel(-1,"系别不存在");
        }
        memberDao.changeDepartment(null,id);
        categoryDao.changeDepartment(null,id);
        if(departmentDao.delete(id) == 1){
            return new ResultModel(1,"删除成功");
        }
        return new ResultModel(-1,"删除失败");
    }

    @Override
    public Department findByid (int id) {
        return departmentDao.findById(id);
    }

    @Override
    public ResultModel departmentList () {
        List<Department> departments = departmentDao.departmentList();
        ResultModel<List<Department>> result = new ResultModel<List<Department>>(0);
        result.setData(departments);
        return result;
    }

}
