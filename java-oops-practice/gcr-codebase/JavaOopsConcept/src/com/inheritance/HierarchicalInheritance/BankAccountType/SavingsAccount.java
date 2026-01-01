package com.inheritance.HierarchicalInheritance.BankAccountType;

public class SavingsAccount extends BankAccount {
    public double interestRate;

    // constructor
    public SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    // display
    public void displayAccountType() {
        System.out.println("Savings Account");
    }
}