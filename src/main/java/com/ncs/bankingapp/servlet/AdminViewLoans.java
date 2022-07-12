package com.ncs.bankingapp.servlet;

import com.ncs.bankingapp.model.Admin;
import com.ncs.bankingapp.model.Loan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminViewLoans", value = "/admin-view-loans")
public class AdminViewLoans extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Loan> loans = new ArrayList<>();
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        Admin admin = new Admin(userName);

        try {
            loans =  admin.viewLoans();
            session.setAttribute("loans",loans);
            response.sendRedirect("view/adminViewLoans.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
