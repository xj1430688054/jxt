package com.gl.jxt.dao;

import org.apache.ibatis.annotations.Param;

import com.gl.jxt.common.base.IBaseDao;
import com.gl.jxt.common.page.Page;
import com.gl.jxt.domain.Item;
import com.gl.jxt.domain.Member;

import java.util.List;

public interface IItemDao extends IBaseDao<Item> {

    /**
     * 获取全部条目
     * @return
     */
    List<Item> itemList();

    /**
     * @param page
     * @return
     */
    List<Item> itemListByPage(@Param("page") Page page);

    /**
     * 更改条目状态
     */
    int changeState();
}
