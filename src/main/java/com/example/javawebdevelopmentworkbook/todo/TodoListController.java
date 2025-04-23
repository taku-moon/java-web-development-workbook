package com.example.javawebdevelopmentworkbook.todo;

import com.example.javawebdevelopmentworkbook.todo.dto.TodoDTO;
import com.example.javawebdevelopmentworkbook.todo.service.TodoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/todo/list")
public class TodoListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
        request.setAttribute("dtoList", dtoList);

        request.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(request, response);
    }
}
