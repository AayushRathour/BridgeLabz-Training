package com.inheritance.HierarchicalInheritance.BankAccountType;

public class BankAccount {
    public int accountNumber;
    public double balance;

    // constructor
    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // display details
    public void displayDetails() {
        System.out.println(accountNumber + " | " + balance);
    }
}