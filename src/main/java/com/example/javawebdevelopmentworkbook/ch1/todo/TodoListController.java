package com.example.javawebdevelopmentworkbook.ch1.todo;

import com.example.javawebdevelopmentworkbook.ch1.todo.dto.TodoDTO;
import com.example.javawebdevelopmentworkbook.ch1.todo.service.TodoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ch1/todo/list")
public class TodoListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<TodoDTO> dtoList = TodoService.INSTANCE.getList();

        request.setAttribute("dtoList", dtoList);

        request.getRequestDispatcher("/WEB-INF/ch1/todo/list.jsp").forward(request, response);
    }
}
