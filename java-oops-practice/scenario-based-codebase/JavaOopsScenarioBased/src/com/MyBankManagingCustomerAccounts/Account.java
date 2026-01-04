package com.MyBankManagingCustomerAccounts;

public abstract class Account implements ITransaction {
    protected int accountNumber;
    private double balance;

    // account with zero balance
    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    // account with opening balance
    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    protected double getBalanceInternal() {
        return balance;
    }

    public double checkBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if(balance < amount) {
            System.out.println("Insufficient balance");
            return;
        }
        balance -= amount;
    }

    public abstract double calculateInterest();
}