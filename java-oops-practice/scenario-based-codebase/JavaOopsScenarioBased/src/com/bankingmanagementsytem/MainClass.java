package com.bankingmanagementsytem;

public class MainClass {
	public static void main(String[] args) {
        Accounts acc = new SavingsAccount(1000, 0.05);
        acc.deposit(500);
        acc.withdraw(200);
    }
	
}
