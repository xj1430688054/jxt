package com.gl.jxt.service;

import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.domain.Category;

public interface ICategoryService {

    ResultModel save(Category category);

    ResultModel update(Category category);

    ResultModel delete(int cid);

    Category findByid(int id);

    ResultModel categoryList();

}
