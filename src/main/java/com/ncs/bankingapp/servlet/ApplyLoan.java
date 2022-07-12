package com.ncs.bankingapp.servlet;

import com.ncs.bankingapp.model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ApplyLoan", value = "/apply-loan")
public class ApplyLoan extends HttpServlet {
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
        int loanAmount =Integer.parseInt(request.getParameter("loanAmount"));

        try {
            Customer customer = new Customer(userName);
            if(customer.applyLoan(loanAmount)){

                response.sendRedirect("view/loanApplied.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
