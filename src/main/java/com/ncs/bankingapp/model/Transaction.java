package com.ncs.bankingapp.model;

import java.sql.Date;

public class Transaction {
    private String userName;
    private int amount;
    private String type;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Transaction() {
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Transaction(String userName, int amount, String type) {
        this.userName = userName;
        this.amount = amount;
        this.type = type;
    }
}
