package com.MyBankManagingCustomerAccounts;

public class MainClass {
    public static void main(String[] args) {
        Account savings = new SavingsAccount(0, 10000);
        Account current = new CurrentAccount(1, 10000);

        savings.deposit(1000);
        current.withdraw(5000);

        System.out.println("Savings Balance " + savings.checkBalance());
        System.out.println("Savings Interest " + savings.calculateInterest());

        System.out.println("Current Balance " + current.checkBalance());
        System.out.println("Current Interest " + current.calculateInterest());
    }
}