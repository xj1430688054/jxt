package com.gl.jxt.dao;

import org.apache.ibatis.annotations.Param;

import com.gl.jxt.common.base.IBaseDao;
import com.gl.jxt.domain.Config;

/**
 * 系统配置信息DAO接口
 */
public interface IConfigDao extends IBaseDao<Config> {

    boolean update(@Param("key") String key, @Param("value") String value);

    String getValue(@Param("key") String key);
}
