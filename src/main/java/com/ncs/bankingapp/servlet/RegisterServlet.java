package com.ncs.bankingapp.servlet;

import com.ncs.bankingapp.model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", value = "/register-servlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected  void service(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        try {
            Customer customer = new Customer(request.getParameter("name"),request.getParameter("userName"),request.getParameter("password"));
            int i = customer.register();
            if(i>0){
                response.sendRedirect("view/registerSuccessLoginCustomer.jsp");
            }
            else if(i==0){
                response.sendRedirect("view/registerFailUserExists.jsp");
            }
            else{
                response.sendRedirect("view/registerFail.jsp");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
