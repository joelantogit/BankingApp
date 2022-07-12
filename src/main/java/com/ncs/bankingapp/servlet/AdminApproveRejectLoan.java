package com.ncs.bankingapp.servlet;

import com.ncs.bankingapp.model.Customer;
import com.ncs.bankingapp.model.Loan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminApproveRejectLoan", value = "/admin-approve-reject-loan")
public class AdminApproveRejectLoan extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String status = request.getParameter("status");
        String userName = request.getParameter("userName");
        int amount = Integer.parseInt(request.getParameter("amount"));
        System.out.println("AdminApproveRejectLoan: service: parameters \n userName -" + userName + "\namount -" + amount);
        if(status.equals("Accept")){
            try {
                Customer customer = new Customer(userName);
                customer.userNameExistsInDb();
                customer.setBalance(customer.getBalance()+amount);
                customer.updateDebit(amount);
                Loan loan = new Loan(userName,amount,"applied");
                loan.updateStatus("approved");
                response.sendRedirect("view/loanApproved.jsp");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
        else if(status.equals("Reject")){

            Loan loan = null;
            try {
                loan = new Loan(userName,amount,"applied");
                loan.updateStatus("rejected");
                response.sendRedirect("view/loanRejected.jsp");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}