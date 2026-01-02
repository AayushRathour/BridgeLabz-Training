package com.encapsulationandpolymorphism.BankingSystem;



import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        List<BankAccount> list = new ArrayList<>();
        list.add(new SavingsAccount(0, "Aayush", 5000));
        list.add(new CurrentAccount(1, "Harsh", 8000));

        for (BankAccount account : list) {
            System.out.println("Account : " + account.getAccountNumber());
            System.out.println("Interest : " + account.calculateInterest());
            account.applyForLoan();
            System.out.println("Loan eligibility : " + account.calculateLoanEligibility());
        }
    }
}