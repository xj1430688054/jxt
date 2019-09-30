package com.gl.jxt.dao;

import org.apache.ibatis.annotations.Param;

import com.gl.jxt.common.base.IBaseDao;
import com.gl.jxt.common.page.Page;
import com.gl.jxt.domain.Teacher;

import java.util.List;

public interface ITeacherDao extends IBaseDao<Teacher> {

    /**
     * 更新学生容量
     * @param count
     * @param id
     */
    int updeteStudenCount(@Param("count") Integer count,@Param("id") Integer id);

    /**
     * 获取全部教师
     */
    List<Teacher> teacherList();

    List<Teacher> teacherListByPage(Page page);

}
