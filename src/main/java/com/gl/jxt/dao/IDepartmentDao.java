package com.gl.jxt.dao;

import org.apache.ibatis.annotations.Param;

import com.gl.jxt.common.base.IBaseDao;
import com.gl.jxt.domain.Department;

import java.util.List;

public interface IDepartmentDao extends IBaseDao<Department> {

    List<Department> departmentList ();

    /**
     * 根据系别名称查询
     * @param name
     * @return
     */
    Department findByName (@Param("name") String name);
}
