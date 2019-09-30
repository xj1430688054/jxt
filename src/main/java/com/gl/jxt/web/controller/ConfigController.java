package com.gl.jxt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gl.jxt.common.annotation.Before;
import com.gl.jxt.common.base.BaseController;
import com.gl.jxt.common.core.Const;
import com.gl.jxt.common.dto.ResultModel;
import com.gl.jxt.domain.Config;
import com.gl.jxt.service.IConfigService;
import com.gl.jxt.web.interceptor.AdminLoginInterceptor;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Before(AdminLoginInterceptor.class)
@RequestMapping(value = "/config")
public class ConfigController extends BaseController {

    @Resource
    IConfigService configService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){
        List<Config> configList = configService.allList();
        for (Config config:configList) {
            model.addAttribute(config.getJkey(),config.getJvalue());
        }
        return "/config";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public ResultModel edit(String IS_OPEN_CHOOSE, String IS_OPEN_GROUP, String IS_OPEN_REGISTER, String MEMBER_ORDER_DELETE){
        Map<String,String> params = new HashMap<>();
        params.put(Const.IS_OPEN_CHOOSE,IS_OPEN_CHOOSE);
        params.put(Const.IS_OPEN_GROUP,IS_OPEN_GROUP);
        params.put(Const.IS_OPEN_REGISTER,IS_OPEN_REGISTER);
        params.put(Const.MEMBER_ORDER_DELETE,MEMBER_ORDER_DELETE);
        return configService.update(params,request);
    }


}
