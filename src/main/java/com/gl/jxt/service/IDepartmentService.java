package com.gl.jxt.service;

import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.domain.Department;

public interface IDepartmentService {

    ResultModel save(Department department);

    ResultModel update(Department department);

    ResultModel delete(int id);

    Department findByid(int id);

    ResultModel departmentList();

}
