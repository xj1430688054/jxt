package com.gl.jxt.service.impl;

import org.springframework.stereotype.Service;

import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.dao.IConfigDao;
import com.gl.jxt.domain.Config;
import com.gl.jxt.service.IConfigService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("configService")
public class ConfigServiceImpl implements IConfigService {

    @Resource
    private IConfigDao configDao;


    @Override
    public List<Config> allList() {
        return configDao.allList();
    }

    @Override
    public Map<String, String> getConfigToMap() {
        List<Config> allList = this.allList();
        Map<String,String> map = new HashMap<>();
        for (Config config : allList) {
            map.put(config.getJkey(),config.getJvalue());
        }
        return map;
    }

    @Override
    public String getValue(String key) {
        return configDao.getValue(key);
    }

    @Override
    public ResultModel update(Map<String, String> params, HttpServletRequest request) {
        for(Map.Entry entry : params.entrySet()){
            if(((String)entry.getValue()).length() > 500){
                return new ResultModel(-1,"只能输入255个字符");
            }else {
                configDao.update((String)entry.getKey(),(String)entry.getValue());
                request.getServletContext().setAttribute(((String)entry.getKey()).toUpperCase(),entry.getValue());
            }
        }
        return new ResultModel(0,"操作成功");
    }

}
