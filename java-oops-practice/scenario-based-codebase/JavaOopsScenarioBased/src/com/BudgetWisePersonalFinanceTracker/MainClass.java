package com.BudgetWisePersonalFinanceTracker;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {

        HashMap<String, Double> limits = new HashMap<>();
        limits.put("Food", 5000.0);
        limits.put("Travel", 3000.0);

        Budget budget = new MonthlyBudget(30000, 20000, limits);

        budget.addTransaction(new Transaction(2000, "EXPENSE", "01-01", "Food"));
        budget.addTransaction(new Transaction(4000, "EXPENSE", "02-01", "Travel"));

        budget.generateReport();
        budget.detectOverspend();
    }
}
