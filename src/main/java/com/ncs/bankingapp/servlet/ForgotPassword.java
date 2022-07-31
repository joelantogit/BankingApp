package com.ncs.bankingapp.servlet;


import com.ncs.bankingapp.model.Customer;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.Random;

@WebServlet(name = "ForgotPassword", value = "/forgot-password")
public class ForgotPassword extends HttpServlet {
    Customer customer = null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String email = request.getParameter("email");

        if(null!=email){

            try {
                customer = new Customer();
                customer.setEmail(email);
                if(customer.emailExistsInDb()){
                    session.setAttribute("email", email);
                    sendEmail(email,session);
                    response.sendRedirect("view/emailSentAfterPasswordChange.jsp");
                }
                else{
                    response.sendRedirect("view/emailNotFound.jsp");
                }


            } catch (MessagingException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }


        else{
            response.sendRedirect("view/landingPage.jsp");
        }
    }

    public void sendEmail(String email, HttpSession httpSession) throws AddressException, MessagingException, SQLException {
        String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
        System.out.println("New password -" + otp);
        customer.changePasswordWithEmail(otp);
        httpSession.setAttribute("otp",otp);
        String fromEmail="joel004@e.ntu.edu.sg"; //sender's mail id.
        String pwd="Ntupassword04";		//sender's mail pwd.
//		String toEmail="raginraju4@gmail.com";  //reciever's mail id.
        //String toEmail="e0648892@u.nus.edu";  //reciever's mail id.
        String toEmail=email;

        String subject="DO NOT REPLY: Reset forgotten password"; // mail subject line
        String msg="Hi, your new password is " + otp ; //mail body

        //Creating Session Object
        Properties prop = new Properties();
        //prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.host", "smtp.office365.com");
        prop.put("mail.smtp.port", 587);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        //prop.put("mail.smtp.starttls.required", "true");
        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                //sender's mail id and pwd is encapsulated inside "SendersCredentials.java"
                return new PasswordAuthentication(fromEmail, pwd);
            }
        });


        //Composing the Mail
        MimeMessage mesg = new MimeMessage(session);
        mesg.setFrom(new InternetAddress(fromEmail));
        mesg.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
        mesg.setSubject(subject);
        mesg.setText(msg);

        //Sending the Mail
        Transport.send(mesg);
        System.out.println("Mail Sent!!");
    }
}
