package com.gl.jxt.service;

import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.common.page.Page;
import com.gl.jxt.domain.Item;

public interface IItemService {

    ResultModel save(Item item);

    Item findById(int iid);

    ResultModel update(Item item);

    ResultModel delete(int iid);

    ResultModel itemList();

    /**
     *
     * @param page
     * @return
     */
    ResultModel itemListByPage(Page page);

    ResultModel itemListByState(int state);

}
