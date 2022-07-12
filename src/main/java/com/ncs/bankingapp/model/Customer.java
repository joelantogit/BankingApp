package com.ncs.bankingapp.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public boolean userNameExistsInDb() throws SQLException {
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

    public Customer(String userName) throws SQLException {
        this();
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

    public int credit(int amount, Date date) throws SQLException {
        String s = "insert into transaction values(?,?,?,?)";
        psmt = con.prepareStatement(s);
        psmt.setString(1,userName);
        psmt.setInt(2,amount);
        psmt.setDate(4,  date);
        psmt.setString(3,"credit");

        return psmt.executeUpdate();
    }


    public int debit(int amount, java.sql.Date date) throws SQLException {
        String s = "insert into transaction values(?,?,?,?)";
        psmt = con.prepareStatement(s);
        psmt.setString(1,userName);
        psmt.setInt(2,amount);
        psmt.setDate(4,  date);
        psmt.setString(3,"debit");

        return psmt.executeUpdate();
    }


    public int updateDebit(int amount) throws SQLException {
        String s = "update customer set balance=(?) where username=(?)";
        psmt = con.prepareStatement(s);
        psmt.setInt(1,balance-amount);
        psmt.setString(2,userName);
        return psmt.executeUpdate();
    }

    public int updateCredit(int amount) throws SQLException {
        String s = "update customer set balance=(?) where username=(?)";
        psmt = con.prepareStatement(s);
        psmt.setInt(1,balance+amount);
        psmt.setString(2,userName);
        return psmt.executeUpdate();
    }

    public List<Transaction> viewTransactions(Date fdate, Date tdate) throws SQLException {

        List<Transaction> transactionList = new ArrayList<>();

        String s = "select * from transaction where userName=(?) AND date between (?) AND (?) ";

        psmt = con.prepareStatement(s);
        psmt.setString(1,userName);
        psmt.setDate(2, fdate);

        psmt.setDate(3, tdate);
        rst = psmt.executeQuery();
        while(rst.next()){
            Transaction transaction = new Transaction();
            transaction.setUserName(rst.getString(1));
            transaction.setAmount(Integer.parseInt(rst.getString(2)));
            transaction.setType(rst.getString(3));
            transaction.setDate(rst.getDate(4));

            transactionList.add(transaction);

        }
        return transactionList;
    }
}
