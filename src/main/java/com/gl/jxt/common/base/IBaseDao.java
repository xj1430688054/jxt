package com.gl.jxt.common.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IBaseDao<T> {

    T findById (@Param("id") Integer id);

    int save (T entity);

    int update (T entity);

    int delete (@Param("id") Integer id);

    List<T> allList ();
}
