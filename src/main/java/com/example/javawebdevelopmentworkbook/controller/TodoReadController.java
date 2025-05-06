package com.example.javawebdevelopmentworkbook.controller;

import com.example.javawebdevelopmentworkbook.dto.TodoDTO;
import com.example.javawebdevelopmentworkbook.service.TodoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
@WebServlet("/todo/read")
public class TodoReadController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info(">> /todo/read doGet()");

        try {
            Long tno = Long.parseLong(request.getParameter("tno"));
            TodoDTO todoDTO = todoService.get(tno);
            request.setAttribute("dto", todoDTO);

            Cookie viewTodoCookie = findCookie(request.getCookies(), "viewTodos");
            String todoListStr = viewTodoCookie.getValue();

            boolean exist = false;

            if (todoListStr != null && todoListStr.contains(tno + "-")) {
                exist = true;
            }

            log.info("exist: " + exist);

            if (!exist) {
                todoListStr += tno + "-";
                viewTodoCookie.setValue(todoListStr);
                viewTodoCookie.setPath("/");
                viewTodoCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(viewTodoCookie);
            }

            request.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(request, response);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("read error");
        }
    }

    private Cookie findCookie(Cookie[] cookies, String cookieName) {
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie;
                }
            }
        }

        Cookie cookie = new Cookie(cookieName, "");
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24);

        return cookie;
    }
}
