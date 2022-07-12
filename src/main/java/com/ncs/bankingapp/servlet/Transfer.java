package com.ncs.bankingapp.servlet;

import com.ncs.bankingapp.model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

@WebServlet(name = "Transfer", value = "/transfer")
public class Transfer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();

        String userName = (String)session.getAttribute("userName");
        Customer customer = new Customer(userName);


        String toUserName = (String) request.getParameter("toCustomer");

        Customer toCustomer = new Customer(toUserName);

        int amount = Integer.parseInt(request.getParameter("amount"));

        try {
            customer.userNameExistsInDb();
            if(toCustomer.userNameExistsInDb() && customer.getBalance() > amount ){
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                java.util.Date dt = new java.util.Date();
                java.sql.Date date = new java.sql.Date(dt.getTime());

                if(customer.debit(amount,date)>0   &&   toCustomer.credit(amount,date)>0   &&   customer.updateDebit(amount)>0 && toCustomer.updateCredit(amount)>0 ){
                    response.sendRedirect("view/transferSuccess.jsp");
                }
                else {
                    response.sendRedirect("view/transferFailed.jsp");
                }

            }
            else{
                response.sendRedirect("view/transferFailed.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
