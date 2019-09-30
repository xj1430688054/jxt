package com.gl.jxt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.common.page.Page;
import com.gl.jxt.dao.ICategoryItemDao;
import com.gl.jxt.dao.IItemDao;
import com.gl.jxt.domain.CategoryItem;
import com.gl.jxt.domain.Item;
import com.gl.jxt.domain.Order;
import com.gl.jxt.service.IItemService;
import com.gl.jxt.service.IOrderService;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements IItemService {

    @Resource
    IItemDao itemDao;

    @Resource
    ICategoryItemDao categoryItemDao;

    @Resource
    IOrderService orderService;

    @Override
    @Transactional
    public ResultModel save (Item item) {
        //默认选取类型为只许个人
        if(item.getType() == null){
            item.setType(0);
        }
        List<CategoryItem> itemCategories = item.getCategories();
        List<CategoryItem> categories = forCategory(itemCategories);
        item.setCategories(categories);
        if(itemDao.save(item) == 1){
            //保存条目分类关系
            for (CategoryItem itemCategory : categories) {
                categoryItemDao.saveItemCategory(item.getId(),itemCategory.getId());
            }
            return new ResultModel(0,"保存成功");
        }
        return new ResultModel(-1,"保存失败");
    }

    /**
     * 遍历保存分类集合
     * @param itemCategories
     */
    private List<CategoryItem> forCategory (List<CategoryItem> itemCategories) {
        List<CategoryItem> categories = categoryItemDao.categoryItemList();
        List<CategoryItem> tureCategories = new LinkedList<CategoryItem>();
        for (int i = 0; i < itemCategories.size() ;i++) {
            for (CategoryItem category : categories) {
                if (category.getId() == itemCategories.get(i).getId()) {
                    tureCategories.add(category);
                }
            }
        }
        return tureCategories;
    }

    @Override
    public Item findById (int iid) {
        return itemDao.findById(iid);
    }

    @Override
    @Transactional
    public ResultModel update (Item item) {
        List<CategoryItem> itemCategories = item.getCategories();
        List<CategoryItem> categories = forCategory(itemCategories);
        item.setCategories(categories);
        if(itemDao.update(item) == 1){
            //保存条目分类关系
                categoryItemDao.deleteItemCategoryByIid(item.getId());
            for (CategoryItem itemCategory : categories) {
                categoryItemDao.saveItemCategory(item.getId(),itemCategory.getId());
            }
            return new ResultModel(1,"更新成功");
        }
        return new ResultModel(-1,"更新失败");
    }

    @Override
    @Transactional
    public ResultModel delete (int iid) {
        if (findById(iid) == null) {
            return new ResultModel(-1,"条目以存在");
        }
        Order order = orderService.selectOrderByIid(iid);
        if(order != null){
            orderService.delete(order.getId());
        }
        //删除分类条目关系
        categoryItemDao.deleteItemCategoryByIid(iid);
        itemDao.delete(iid);
        return new ResultModel(1,"操作成功");
    }


    @Override
    public ResultModel itemList () {
        List<Item> items = itemDao.itemList();
        ResultModel result = new ResultModel(0);
        result.setData(items);
        return result;
    }

    @Override
    public ResultModel itemListByPage (Page page) {
        List<Item> list = itemDao.itemListByPage(page);
        ResultModel result = new ResultModel(0,page);
        result.setData(list);
        return result;
    }

    @Override
    public ResultModel itemListByState (int state) {
        return null;
    }
}
