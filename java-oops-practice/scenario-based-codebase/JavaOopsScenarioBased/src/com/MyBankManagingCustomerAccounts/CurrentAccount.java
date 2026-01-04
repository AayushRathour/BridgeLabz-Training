package com.MyBankManagingCustomerAccounts;

public class CurrentAccount extends Account {
    private double interestRate = 5.0;

    public CurrentAccount(int accountNumber) {
        super(accountNumber);
    }

    public CurrentAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public double calculateInterest() {
        double interest = getBalanceInternal() * interestRate / 100;
        return interest;
    }
}