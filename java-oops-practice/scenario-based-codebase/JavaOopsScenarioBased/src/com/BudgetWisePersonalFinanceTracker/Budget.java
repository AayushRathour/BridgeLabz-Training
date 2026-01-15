package com.BudgetWisePersonalFinanceTracker;


import java.util.*;

public abstract class Budget implements IAnalyzable {

    protected double income;
    protected double limit;
    protected HashMap<String, Double> categoryLimits;
    protected ArrayList<Transaction> transactions;

    Budget(double income, double limit, HashMap<String, Double> categoryLimits) {
        this.income = income;
        this.limit = limit;
        this.categoryLimits = categoryLimits;
        this.transactions = new ArrayList<>();
    }

    void addTransaction(Transaction t) {
        transactions.add(t);
    }

    double totalExpenses() {
        double sum = 0;
        for (Transaction t : transactions) {
            if (t.getType().equals("EXPENSE")) {
                sum += t.getAmount();
            }
        }
        return sum;
    }

    double netSavings() {
        return income - totalExpenses();
    }
}
