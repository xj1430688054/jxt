package com.gl.jxt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class IndexController {


    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "/index";
    }

    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String welcome(){
        return "/welcome";
    }

}
