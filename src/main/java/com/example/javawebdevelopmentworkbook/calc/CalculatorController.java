package com.example.javawebdevelopmentworkbook.calc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/calc")
public class CalculatorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("InputController...doGet()...");

        request.getRequestDispatcher("/WEB-INF/calc/input.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("InputController...doPost()...");

        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String sum = Integer.toString(Integer.parseInt(num1) + Integer.parseInt(num2));

        request.setAttribute("num1", num1);
        request.setAttribute("num2", num2);
        request.setAttribute("sum", sum);

        request.getRequestDispatcher("/WEB-INF/calc/output.jsp").forward(request, response);
    }
}
