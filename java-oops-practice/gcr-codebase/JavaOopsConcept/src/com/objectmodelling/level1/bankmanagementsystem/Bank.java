package com.objectmodelling.level1.bankmanagementsystem;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<BankAccount> accounts;

    // constructor
    public Bank(String bankName) {
        this.name = bankName;
        this.accounts = new ArrayList<>();
    }

    // method to open account
    public BankAccount openAccount(Customer customer, int balance) {
        BankAccount account = new BankAccount(customer, this, balance);
        accounts.add(account);
        customer.addAccount(account);
        return account;
    }
    
    // method to return bank name
    public String getName() {
    	return name;
    }
}   