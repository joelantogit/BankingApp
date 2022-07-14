package com.ncs.bankingapp.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Admin {
    private String userName;
    private String password;

    static Connection con;
    static PreparedStatement psmt;
    static Statement smt;
    static ResultSet rst;

    public Admin(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        con = DriverManager.getConnection("jdbc:mysql://localhost/bank_db","root","root");
        System.out.println("Customer  : Connected to db");
    }

    public Admin(String userName, String password) throws SQLException {
        this();
        this.userName = userName;
        this.password = password;
    }

    public boolean login() throws SQLException {
        String s = "select * from admin";
        smt = con.createStatement();


        rst = smt.executeQuery(s);

            if(rst.next()){
                if(rst.getString(1).equals(userName)){
                    if(rst.getString(2).equals(password)){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }

    public List<Loan> viewLoans() throws SQLException {
        List<Loan> loans = new ArrayList<>();
        String s = "select * from loan where status =(?)";
        psmt = con.prepareStatement(s);
        psmt.setString(1,"applied");
        rst = psmt.executeQuery();
        while(rst.next()){
            Loan loan = new Loan();
            loan.setUserName(rst.getString(1));
            loan.setAmount(rst.getInt(2));
            loan.setStatus(rst.getString(3));
            loans.add(loan);
        }
        return loans;
    }

    public List<Customer> getAllCustomers() throws SQLException {

        List<Customer> customers = new ArrayList<>();
        String s = "select * from customer";
        smt = con.createStatement();
        rst = smt.executeQuery(s);
        while(rst.next()){
            Customer customer = new Customer();
            customer.setName(rst.getString(1));
            customer.setUserName(rst.getString(2));
            customer.setBalance(rst.getInt(4));
            customers.add(customer);
        }
        return customers;
    }
}
