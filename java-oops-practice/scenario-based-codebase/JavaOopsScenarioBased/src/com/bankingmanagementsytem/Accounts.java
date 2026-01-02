package com.bankingmanagementsytem;

public class Accounts{
    protected double balance;

    Accounts(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        balance -= amount;
    }
}
