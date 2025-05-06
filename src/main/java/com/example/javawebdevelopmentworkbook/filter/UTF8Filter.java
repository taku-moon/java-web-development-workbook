package com.example.javawebdevelopmentworkbook.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
@WebFilter("/*")
public class UTF8Filter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info(">> UTF8 filter");

        HttpServletRequest req = (HttpServletRequest) request;

        request.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
    }
}
