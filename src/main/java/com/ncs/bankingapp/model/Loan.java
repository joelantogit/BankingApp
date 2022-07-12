package com.ncs.bankingapp.model;

import java.sql.*;

public class Loan {
    private String userName;
    private int amount;
    private String status;
    static Connection con;
    static PreparedStatement psmt;
    static Statement smt;
    static ResultSet rst;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Loan() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        con = DriverManager.getConnection("jdbc:mysql://localhost/bank_db","root","root");
        System.out.println("Customer  : Connected to db");
    }

    public Loan(String userName, int amount, String status) throws SQLException {
        this();
        this.userName = userName;
        this.amount = amount;
        this.status = status;
    }

    public void updateStatus(String status) throws SQLException {
        String s = "update loan set status=(?) where userName=(?) AND amount=(?)";
        psmt = con.prepareStatement(s);
        psmt.setString(1,status);
        psmt.setString(2,userName);
        psmt.setInt(3,amount);

        psmt.executeUpdate();

    }
}
