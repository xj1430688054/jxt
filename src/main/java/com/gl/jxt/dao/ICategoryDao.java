package com.gl.jxt.dao;

import org.apache.ibatis.annotations.Param;

import com.gl.jxt.common.base.IBaseDao;
import com.gl.jxt.domain.Category;
import com.gl.jxt.domain.CategoryItem;

import java.util.List;

public interface ICategoryDao extends IBaseDao<Category> {

    /**
     * 获取全部分类
     * @return
     */
    List<Category> categoryList();

    List<CategoryItem> categoryItemList();

    Category findByName(@Param("name")String name);

    /**
     * 更改系别
     * @param nDid
     * @param did
     * @return
     */
    int changeDepartment(@Param("nDid") Integer nDid, @Param("did") Integer did);

}
