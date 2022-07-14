package com.ncs.bankingapp.servlet;

import com.ncs.bankingapp.model.Customer;
import com.ncs.bankingapp.model.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "ViewTransactions", value = "/view-transactions")
public class ViewTransactions extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String fd = request.getParameter("fromDate");
        String td = request.getParameter("toDate");

        System.out.println("ViewTransactions: service: from date - " + fd);
        System.out.println("ViewTransactions: service: to date - " + td);


        Long fd_ = java.util.Date.parse(fd);
        Long td_ = java.util.Date.parse(td);


        java.sql.Date fdate = new Date(fd_);
        java.sql.Date tdate = new Date(td_);



        HttpSession session = request.getSession();
        String userName = (String)session.getAttribute("userName");

        if(null == userName){
            response.sendRedirect("index.jsp");
        }
        else{
            Customer customer = null;
            try {
                customer = new Customer(userName);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                List<Transaction> transactionList = customer.viewTransactions(fdate,tdate);
                session.setAttribute("transactionList", transactionList);
                response.sendRedirect("view/viewTransactionsList.jsp");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

