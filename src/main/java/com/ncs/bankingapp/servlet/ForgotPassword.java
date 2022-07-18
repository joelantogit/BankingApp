package com.ncs.bankingapp.servlet;


import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.Random;

@WebServlet(name = "ForgotPassword", value = "/forgot-password")
public class ForgotPassword extends HttpServlet {
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
        Integer otp  = null;
        int otpFromSession =Integer.parseInt(request.getParameter("otp")) ;
        if(null!=request.getParameter("otp")){
            otp = Integer.parseInt(request.getParameter("otp"));

        }

        if(null!=email){
            session.setAttribute("email", email);
            try {
                sendEmail(email,session);
                response.sendRedirect("view/enterOtp.jsp");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }

        }
        else if(null!=otp){
            if(otp.equals(otpFromSession)){

                response.sendRedirect("view/changePassword.jsp");
            }
        }

        else{
            response.sendRedirect("view/landingPage.jsp");
        }
    }

    public void sendEmail(String email, HttpSession httpSession) throws AddressException, MessagingException
    {
        String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
        httpSession.setAttribute("otp",otp);
        String fromEmail="joel004@e.ntu.edu.sg"; //sender's mail id.
        String pwd="Ntupassword04";		//sender's mail pwd.
//		String toEmail="raginraju4@gmail.com";  //reciever's mail id.
        //String toEmail="e0648892@u.nus.edu";  //reciever's mail id.
        String toEmail=email;

        String subject="DO NOT REPLY: Reset forgotten password"; // mail subject line
        String msg="Hi, your OTP is " + otp ; //mail body

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
