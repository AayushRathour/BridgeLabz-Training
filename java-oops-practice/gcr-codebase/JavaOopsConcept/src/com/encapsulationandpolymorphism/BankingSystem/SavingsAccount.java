package com.encapsulationandpolymorphism.BankingSystem;

public class SavingsAccount extends BankAccount {
    // constructor
    public SavingsAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    // interest calculation
    public double calculateInterest() {
        return getBalance() * 0.04;
    }

    public void applyForLoan() {
        System.out.println("Savings account loan applied");
    }

    public int calculateLoanEligibility() {
        return (int)(getBalance() * 5);
    }
}