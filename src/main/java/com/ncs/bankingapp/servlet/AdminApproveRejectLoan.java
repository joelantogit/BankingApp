package com.ncs.bankingapp.servlet;

import com.ncs.bankingapp.model.Admin;
import com.ncs.bankingapp.model.Customer;
import com.ncs.bankingapp.model.Loan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

        List<Loan> allLoans = new ArrayList<>();
        List<Loan> pendingLoans = new ArrayList<>();

        HttpSession session = request.getSession();

        Admin admin;
        String status = request.getParameter("status");
        String userName = request.getParameter("userName");
        if(null==userName){
            response.sendRedirect("index.jsp");
        }
        else{
            admin = new Admin(userName);
            int amount = Integer.parseInt(request.getParameter("amount"));
            System.out.println("AdminApproveRejectLoan: service: parameters \n userName -" + userName + "\namount -" + amount);
            if(status.equals("Accept")){
                try {
                    Customer customer = new Customer(userName);
                    customer.userNameExistsInDb();
                    //customer.setBalance(customer.getBalance()+amount);
                    customer.updateCredit(amount);
                    Loan loan = new Loan(userName,amount,"applied");
                    loan.updateStatus("approved");
                    allLoans =  admin.getAllLoans();
                    pendingLoans = admin.getPendingLoans();
                    session.setAttribute("allLoans",allLoans);
                    session.setAttribute("pendingLoans",pendingLoans);
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
                    allLoans =  admin.getAllLoans();
                    pendingLoans = admin.getPendingLoans();
                    session.setAttribute("allLoans",allLoans);
                    session.setAttribute("pendingLoans",pendingLoans);
                    response.sendRedirect("view/loanRejected.jsp");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
