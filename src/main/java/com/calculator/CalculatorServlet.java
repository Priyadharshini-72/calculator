package com.calculator;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalculatorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        String op = request.getParameter("op");

        int result = 0;

        switch (op) {
            case "add":
                result = num1 + num2;
                break;

            case "sub":
                result = num1 - num2;
                break;

            case "mul":
                result = num1 * num2;
                break;

            case "div":
                if (num2 != 0)
                    result = num1 / num2;
                else
                    out.println("Cannot divide by zero");
                break;
        }

        out.println("<h2>Result: " + result + "</h2>");
    }
}