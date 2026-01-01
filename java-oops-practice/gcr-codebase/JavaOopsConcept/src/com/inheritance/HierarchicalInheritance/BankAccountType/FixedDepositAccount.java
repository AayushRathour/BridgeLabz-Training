package com.inheritance.HierarchicalInheritance.BankAccountType;

public class FixedDepositAccount extends BankAccount {
    public int lockPeriod;

    // constructor
    public FixedDepositAccount(int accountNumber, double balance, int lockPeriod) {
        super(accountNumber, balance);
        this.lockPeriod = lockPeriod;
    }

    // display
    public void displayAccountType() {
        System.out.println("Fixed Deposit Account");
    }
}