package com.constructor.level1;

public class BankAccount {
	public int accountNumber;
	protected String accountHolder;
	private int balance;
	
	// getter for balance
	public int getBalance() {
		return balance;
	}
	
	// setter for balance
	public void setBalance(int balance) {
		this.balance = balance;
	}
}