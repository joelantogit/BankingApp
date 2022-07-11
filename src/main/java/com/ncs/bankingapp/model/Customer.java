package com.ncs.bankingapp.model;

import java.sql.*;

public class Customer {


    private String name;

    private String userName;

    private String password;

    private int balance;

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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int register() throws SQLException {

        if(userNameExistsInDb()) {
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
        System.out.println("Customer: userNameExistsInDB: query for userName completed -" + this.userName );
        if(rst.next()){
            System.out.println("Customer: userNameExistsInDB: userName exists");
            name = rst.getString(1);
            balance = rst.getInt(4);
            return true;
        }
        else {
            System.out.println("Customer: userNameExistsInDB: userName does not exist");
            return false;
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
                System.out.println("customer: login: password verified");

                name = rst.getString(1);
                userName = rst.getString(2);
                balance = rst.getInt(4);
                System.out.println("customer: login: balance - " + balance);
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    private boolean comparePasswords(String password, String passwordDb) {
        return password.equals(passwordDb) ? true:false;
    }

    public Customer(String userName) {
        this.userName = userName;
    }

    public int changePassword(String newPassword) throws SQLException {


        String s1 = "update customer set password=(?) where userName=(?)";
        psmt = con.prepareStatement(s1);
        psmt.setString(1,newPassword);
        psmt.setString(2,userName);
        return psmt.executeUpdate();
    }

    public void viewBalance() throws SQLException {
        userNameExistsInDb();
        System.out.println("balance updated to customer object " + balance);
    }
}
