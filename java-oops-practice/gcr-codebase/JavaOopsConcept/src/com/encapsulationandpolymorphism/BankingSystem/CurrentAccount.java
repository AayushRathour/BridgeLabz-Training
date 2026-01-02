package com.encapsulationandpolymorphism.BankingSystem;

public class CurrentAccount extends BankAccount {
    // constructor
    public CurrentAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    // interest calculation
    public double calculateInterest() {
        return getBalance() * 0.02;
    }

    public void applyForLoan() {
        System.out.println("Current account loan applied");
    }

    public int calculateLoanEligibility() {
        return (int)(getBalance() * 10);
    }
}