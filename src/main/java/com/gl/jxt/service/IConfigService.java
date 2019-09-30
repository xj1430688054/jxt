package com.gl.jxt.service;

import javax.servlet.http.HttpServletRequest;

import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.domain.Config;

import java.util.List;
import java.util.Map;

public interface IConfigService {

    List<Config> allList();

    Map<String,String> getConfigToMap();

    String getValue(String key);

    ResultModel update(Map<String,String> params, HttpServletRequest request);
}
