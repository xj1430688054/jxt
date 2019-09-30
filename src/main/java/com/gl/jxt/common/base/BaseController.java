package com.gl.jxt.common.base;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {

    @Resource
    protected HttpServletRequest request;

    @Resource
    protected HttpServletResponse response;

    protected String getParam(String name){
        return request.getParameter(name);
    }

    protected String getParam(String name, String defaultValue){
        String value = getParam(name);
        if (null == value){
            value = defaultValue;
        }
        return value;
    }

    protected int getParamToInt(String name) throws RuntimeException {
        String value = getParam(name);
        try {
            return Integer.parseInt(value);
        }catch (Exception e){
            throw new RuntimeException("参数异常");
        }
    }

    protected int getParamToInt(String name, int defaultValue){
        try {
            return getParamToInt(name);
        } catch (RuntimeException paramException) {
            return defaultValue;
        }
    }

    protected double getParamToDouble(String name) throws RuntimeException {
        String value = getParam(name);
        try {
            return Double.parseDouble(value);
        }catch (Exception e){
            throw new RuntimeException("参数异常");
        }
    }

    protected double getParamToInt(String name, double defaultValue){
        try {
            return getParamToDouble(name);
        } catch (RuntimeException paramException) {
            return defaultValue;
        }
    }

}
