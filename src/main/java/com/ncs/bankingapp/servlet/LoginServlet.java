package com.ncs.bankingapp.servlet;

import com.mysql.cj.Session;
import com.ncs.bankingapp.model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "LoginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Customer customer = null;
        try {
            customer = new Customer(request.getParameter("userName"),request.getParameter("password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if(customer.login()){
                HttpSession session = request.getSession();
                System.out.println("setting session userName " + customer.getUserName());
                session.setAttribute("userName", customer.getUserName());
                System.out.println("session id -" + session.getId());
                response.sendRedirect("view/homePage.jsp");
            }
            else {
                response.sendRedirect("view/loginFailed.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
