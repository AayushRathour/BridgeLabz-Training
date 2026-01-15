package com.BudgetWisePersonalFinanceTracker;


import java.util.*;

public class MonthlyBudget extends Budget {

    MonthlyBudget(double income, double limit, HashMap<String, Double> categoryLimits) {
        super(income, limit, categoryLimits);
    }

    public void generateReport() {
        System.out.println("Monthly Report");
        System.out.println("Savings: " + netSavings());
    }

    public void detectOverspend() {
        HashMap<String, Double> spent = new HashMap<>();

        for (Transaction t : transactions) {
            if (t.getType().equals("EXPENSE")) {
                spent.put(t.getCategory(),
                        spent.getOrDefault(t.getCategory(), 0.0) + t.getAmount());
            }
        }

        for (String c : spent.keySet()) {
            if (spent.get(c) > categoryLimits.get(c)) {
                System.out.println("Overspent in: " + c);
            }
        }
    }
}
