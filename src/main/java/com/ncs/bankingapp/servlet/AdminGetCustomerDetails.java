package com.ncs.bankingapp.servlet;

import com.ncs.bankingapp.model.Admin;
import com.ncs.bankingapp.model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminGetCustomerDetails", value = "/admin-get-customer-details")
public class AdminGetCustomerDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        if(null == userName ){
            response.sendRedirect("index.jsp");
        }
        else{
            Admin admin =new Admin(userName);
            try {
                List<Customer> customers = admin.getAllCustomers();
                session.setAttribute("customers", customers);
                response.sendRedirect("view/adminViewCustomerList.jsp");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
