package com.x.entity;

public class Bank {
    private String accountid;
    private Double balance;

    public Bank() {
    }

    public Bank(String accountid, Double balance) {
        this.accountid = accountid;
        this.balance = balance;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
