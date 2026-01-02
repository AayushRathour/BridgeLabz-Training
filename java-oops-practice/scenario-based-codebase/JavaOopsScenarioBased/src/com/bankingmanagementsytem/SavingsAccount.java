package com.bankingmanagementsytem;

class SavingsAccount extends Accounts {
    double interestRate;

    SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    void calculateInterest() {
        balance += balance * interestRate;
    }
}
