package com.example.javawebdevelopmentworkbook.ch1.todo;

import com.example.javawebdevelopmentworkbook.ch1.todo.dto.TodoDTO;
import com.example.javawebdevelopmentworkbook.ch1.todo.service.TodoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ch1/todo/read")
public class TodoReadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long tno = Long.parseLong(request.getParameter("tno"));

        TodoDTO dto = TodoService.INSTANCE.get(tno);

        request.setAttribute("dto", dto);

        request.getRequestDispatcher("/WEB-INF/ch1/todo/read.jsp").forward(request, response);
    }
}
