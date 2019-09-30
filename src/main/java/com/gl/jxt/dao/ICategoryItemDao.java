package com.gl.jxt.dao;

import org.apache.ibatis.annotations.Param;

import com.gl.jxt.common.base.IBaseDao;
import com.gl.jxt.domain.Category;
import com.gl.jxt.domain.CategoryItem;
import com.gl.jxt.domain.Item;

import java.util.List;

public interface ICategoryItemDao extends IBaseDao {

    /**
     * 保存条目分类关系
     * @param iid
     * @param cid
     */
    int saveItemCategory(@Param("iid") Integer iid, @Param("cid") Integer cid);

    /**
     * 删除条目分类关系
     * @param iid
     */
    int deleteItemCategoryByIid(@Param("iid") Integer iid);

    /**
     * 删除条目分类关系
     * @param cid
     */
    int deleteItemCategoryByCid(@Param("cid") Integer cid);

    /**
     * 根据分类id获取条目
     * @param cid
     * @return
     */
    List<Item> getItemsByCid(@Param("cid")Integer cid);

    /**
     * 根据条目id和分类id更新选取状态
     * @param iid 条目id
     * @param cid 分类id
     * @param state 状态 0:未选取 1:已选取
     */
    int updateStateByIidAndCid(@Param("state")Integer state , @Param("iid") Integer iid ,@Param("cid") Integer cid);

    /**
     * 根据条目id和选取状态获取分类
     * @param iid
     * @param state
     * @return
     */
    List<CategoryItem> selectItemByIdAndState(@Param("iid") Integer iid,@Param("state") Integer state);

    /**
     * 根据条目id和分类id查询分类条目
     * @param iid
     * @param cid
     * @return
     */
    CategoryItem selectCategoryItemByIidAndCid(@Param("iid") Integer iid,@Param("cid") Integer cid);

    /**
     * 获取全部分类
     * @return
     */
    List<CategoryItem> categoryItemList();
}
