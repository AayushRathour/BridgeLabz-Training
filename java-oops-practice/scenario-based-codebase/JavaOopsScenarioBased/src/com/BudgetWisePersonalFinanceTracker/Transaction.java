package com.BudgetWisePersonalFinanceTracker;


public class Transaction {

    private double amount;
    private String type;
    private String date;
    private String category;

    Transaction(double amount, String type, String date, String category) {
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.category = category;
    }

    double getAmount() {
        return amount;
    }

    String getCategory() {
        return category;
    }

    String getType() {
        return type;
    }
}
