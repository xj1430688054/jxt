package com.gl.jxt.service;

import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.common.page.Page;
import com.gl.jxt.domain.Teacher;

public interface ITeacherService {

    ResultModel save(Teacher teacher);

    ResultModel update(Teacher teacher);

    ResultModel delect(int id);

    ResultModel teacherListByPage(Page page);

    ResultModel teacherList();

    Teacher findById(int tid);

    /**
     * 更新学生数量
     * @param id
     * @param count
     * @return
     */
    ResultModel updeteStudenCount(int id,int count);

    /**
     * 查看教师是否可以被选取
     * @param tid
     * @return
     */
    boolean isCanBeChoose(int tid);

}
