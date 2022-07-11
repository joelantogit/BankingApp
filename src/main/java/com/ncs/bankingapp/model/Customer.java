package com.ncs.bankingapp.model;

import java.sql.*;

public class Customer {


    private String name;

    private String userName;

    private String password;

    private String balance;

    static Connection con;
    static PreparedStatement psmt;
    static Statement smt;
    static ResultSet rst;


    Customer() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        con = DriverManager.getConnection("jdbc:mysql://localhost/bank_db","root","root");
        System.out.println("Customer  : Connected to db");
    }
    public Customer(String name, String userName, String password) throws SQLException {
        this();
        this.name = name;
        this.userName = userName;
        this.password = password;

    }

    public Customer(String userName, String password) throws SQLException {
        this();
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getBalance() {
        return balance;
    }

    public void setBalance(String email) {
        this.balance = email;
    }

    public int register() throws SQLException {

        if(!userNameExistsInDb()) {
            return 0;
        }
        else{
            String s = "insert into customer values (?,?,?,?)";
            psmt = con.prepareStatement(s);
            psmt.setString(1, name);
            psmt.setString(2,userName);
            psmt.setString(3,password);
            psmt.setInt(4, 5000);
            System.out.println("Customer: register: Saving to DB");

            return psmt.executeUpdate();
        }
    }

    private boolean userNameExistsInDb() throws SQLException {
        String s = "select * from customer where userName=(?)";
        psmt = con.prepareStatement(s);
        psmt.setString(1,userName);

        rst = psmt.executeQuery();
        System.out.println("Customer: userNameExistsInDB: query for userName completed");
        if(rst.next()){
            System.out.println("Customer: userNameExistsInDB: userName does not exist");
            return false;
        }
        else {
            return true;
        }
    }

    public boolean login() throws SQLException {
        String s1 = "select * from customer where userName=?";

        psmt = con.prepareStatement(s1);
        psmt.setString(1,userName);
        rst = psmt.executeQuery();
        System.out.println("customer: login: searching username in table");
        if(rst.next()){
            String passwordDb = rst.getString(3);
            System.out.println("customer: login: checking password");
            if(comparePasswords(password, passwordDb)){

                name = rst.getString(1);
                userName = rst.getString(2);
                balance = (rst.getString(4));
                return true;
            }
        }
        return false;
    }

    private boolean comparePasswords(String password, String passwordDb) {
        return password.equals(passwordDb) ? true:false;
    }
}
