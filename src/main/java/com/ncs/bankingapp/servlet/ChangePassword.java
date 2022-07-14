package com.ncs.bankingapp.servlet;

import com.ncs.bankingapp.model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ChangePassword", value = "/change-password")
public class ChangePassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        if(null==userName){
            response.sendRedirect("index.jsp");
        }
        else{
            Customer customer = null;
            try {
                customer = new Customer(userName,request.getParameter("currentPassword"));
                if(customer.login()){
                    System.out.println("ChangePassword: service: user verified");
                    if(customer.changePassword(request.getParameter("newPassword"))>0){
                        System.out.println("ChangePassword: service: password updated");
                        response.sendRedirect("view/passwordChanged.jsp");
                    }
                    else{
                        response.sendRedirect("view/passwordChangeFailed.jsp");
                    }
                }
                else{
                    response.sendRedirect("view/passwordChangeFailed.jsp");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
