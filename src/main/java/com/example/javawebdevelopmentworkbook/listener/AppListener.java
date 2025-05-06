package com.example.javawebdevelopmentworkbook.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("ServletContextListener contextInitialized");

        sce.getServletContext().setAttribute("appName", "W2");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("ServletContextListener contextDestroyed");
    }
}
