package com.objectmodelling.level1.bankmanagementsystem;

public class BankManagementSystem {
	public static void main(String[] args) {
		// creating object
        Bank bank = new Bank("State Bank");
        Customer customer = new Customer("Tarun");

        bank.openAccount(customer, 5000);
        bank.openAccount(customer, 12000);

        customer.viewBalance();
    }
}
