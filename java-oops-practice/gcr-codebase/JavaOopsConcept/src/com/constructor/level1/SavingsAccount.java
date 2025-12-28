package com.constructor.level1;

public class SavingsAccount extends BankAccount{

	public static void main(String[] args) {
		// creating object to access to accountNumber and accountHolder.
		SavingsAccount account1 = new SavingsAccount();
		account1.accountHolder = "Name";
		account1.accountNumber = 1;
	}
}