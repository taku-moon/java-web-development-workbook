package com.example.javawebdevelopmentworkbook.controller;

import com.example.javawebdevelopmentworkbook.dto.TodoDTO;
import com.example.javawebdevelopmentworkbook.service.TodoService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet("/todo/list")
public class TodoListController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info(">> /todo/list doGet()");

        ServletContext servletContext = request.getServletContext();

        log.info("appName: " + servletContext.getAttribute("appName"));

        try {
            List<TodoDTO> dtoList = todoService.listAll();
            request.setAttribute("dtoList", dtoList);
            request.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(request, response);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("list error");
        }
    }
}
