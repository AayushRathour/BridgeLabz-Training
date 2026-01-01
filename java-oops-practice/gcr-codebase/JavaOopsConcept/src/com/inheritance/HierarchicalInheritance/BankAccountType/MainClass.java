package com.inheritance.HierarchicalInheritance.BankAccountType;

public class MainClass {
	public static void main(String[] args) {
		// creating object
        SavingsAccount savingsAccount = new SavingsAccount(0, 1000, 10);
        CheckingAccount checkingAccount = new CheckingAccount(1, 1000, 100);
        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount(2, 1000, 10);

        savingsAccount.displayAccountType();
        savingsAccount.displayDetails();
        checkingAccount.displayAccountType();
        checkingAccount.displayDetails();
        fixedDepositAccount.displayAccountType();
        fixedDepositAccount.displayDetails();
    }
}
