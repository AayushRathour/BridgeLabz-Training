package com.objectmodelling.level1.bankmanagementsystem;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<BankAccount> accounts;

    // constructor
    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    // method to add bank account
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    // method to print balance
    public void viewBalance() {
        for (BankAccount account : accounts) {
            System.out.println("Bank: " + account.getBank().getName() + "  Balance: " + account.getBalance());
        }
    }
}    