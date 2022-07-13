package com.ncs.bankingapp.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "session-filter",
//        servletNames = {"/admin-approve-reject-loan",
//        "/admin-login"})
@WebFilter(value = "/view/admin*")

public class SessionFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpSession session = request1.getSession();
        HttpServletResponse response1 = (HttpServletResponse) response;



        if(request1.getSession(false).equals(null)){
            response1.sendRedirect("view/index.jsp");

        }
        else{
            chain.doFilter(request, response);
        }


    }

}
