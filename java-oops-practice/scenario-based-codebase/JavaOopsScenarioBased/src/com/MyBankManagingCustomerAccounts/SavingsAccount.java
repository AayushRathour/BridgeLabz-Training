package com.MyBankManagingCustomerAccounts;

public class SavingsAccount extends Account {
    private double interestRate = 10.0;

    public SavingsAccount(int accountNumber) {
        super(accountNumber);
    }

    public SavingsAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public double calculateInterest() {
        double interest = getBalanceInternal() * interestRate / 100;
        return interest;
    }
}