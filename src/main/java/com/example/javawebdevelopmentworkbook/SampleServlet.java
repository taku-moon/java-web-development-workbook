package com.example.javawebdevelopmentworkbook;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/sample")
public class SampleServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("SampleServlet init()");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SampleServlet doGet()");
        System.out.println(this);
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void destroy() {
        System.out.println("SampleServlet destroy()");
    }
}
