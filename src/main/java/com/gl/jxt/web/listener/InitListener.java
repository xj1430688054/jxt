package com.gl.jxt.web.listener;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.gl.jxt.common.core.Const;
import com.gl.jxt.domain.Config;
import com.gl.jxt.service.IConfigService;

import java.util.List;

@WebListener
public class InitListener implements ServletContextListener {

    @Resource
    IConfigService configService;

    @Override
    public void contextInitialized (ServletContextEvent sce) {
        try{
            Const.PROJECT_PATH = sce.getServletContext().getContextPath();
            sce.getServletContext().setAttribute("basePath", Const.PROJECT_PATH);
            List<Config> configList = configService.allList();
            for (Config config : configList) {
                sce.getServletContext().setAttribute(config.getJkey().toUpperCase(),config.getJvalue());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed (ServletContextEvent sce) {

    }
}
