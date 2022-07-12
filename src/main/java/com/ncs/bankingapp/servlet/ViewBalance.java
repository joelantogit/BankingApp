package com.ncs.bankingapp.servlet;

import com.ncs.bankingapp.model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ViewBalance", value = "/view-balance")
public class ViewBalance extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        System.out.println("sessionid in viewBalance - " + session.getId());
        String userName =  (String)session.getAttribute("userName");
        System.out.println("username from session - " + userName);
        Customer customer = null;
        try {
            customer = new Customer(userName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("setting customer username from session " + customer.getUserName());
        try {
            customer.viewBalance();
            session.setAttribute("balance",customer.getBalance());
            response.sendRedirect("view/viewBalance.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } {

        }
    }

}
