package com.objectmodelling.level1.bankmanagementsystem;

public class BankAccount {
	private Customer customer;
    private Bank bank;
    private double balance;

    // constructor
    public BankAccount(Customer customer, Bank bank, double balance) {
        this.customer = customer;
        this.bank = bank;
        this.balance = balance;
    }

    // getter for balance and name
    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }
}
