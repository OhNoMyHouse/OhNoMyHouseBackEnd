package com.ssafy.happyhouse.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RootPathListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce) {

    }

    public void contextInitialized(ServletContextEvent sce) {
        log.info("root set...");
        ServletContext ctx = sce.getServletContext();
        ctx.setAttribute("root", ctx.getContextPath());
    }

}
