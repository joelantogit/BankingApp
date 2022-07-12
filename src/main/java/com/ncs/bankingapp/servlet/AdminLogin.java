package com.ncs.bankingapp.servlet;

import com.ncs.bankingapp.model.Admin;
import com.ncs.bankingapp.model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.tree.ExpandVetoException;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminLogin", value = "/admin-login")
public class AdminLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String userName = request.getParameter("userName");
        String password = request.getParameter("password");


        try {
            Admin admin = new Admin(userName, password);
            if (admin.login()) {
                HttpSession session = request.getSession();
                session.setAttribute("userName", admin.getUserName());
                response.sendRedirect("view/adminHomePage.jsp");
            } else {
                response.sendRedirect("view/adminLoginFailed.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
