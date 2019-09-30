package com.gl.jxt.dao;

import org.apache.ibatis.annotations.Param;

import com.gl.jxt.common.base.IBaseDao;

public interface ICategoryTeacherDao extends IBaseDao {

    /**
     * 保存教师分类关系
     * @param cid
     * @param cid
     */
    int saveTeacherCategory(@Param("tid") Integer tid, @Param("cid") Integer cid);

    /**
     * 根据教师id删除教师分类关系
     * @param tid
     */
    int deleteTeacherCategoryByTid(@Param("tid") Integer tid);

    /**
     * 根据分类id删除教师分类关系
     * @param cid
     */
    int deleteTeacherCategoryByCid(@Param("cid") Integer cid);

    /**
     * 通过教师id和分类id教师分类关系
     * @param tid
     * @param cid
     * @return
     */
    int deleteTeacherCategoryByTidAndCid(@Param("tid") Integer tid,@Param("cid") Integer cid);
}
