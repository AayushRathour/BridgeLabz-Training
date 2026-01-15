package com.BudgetWisePersonalFinanceTracker;


import java.util.*;

public class AnnualBudget extends Budget {

    AnnualBudget(double income, double limit, HashMap<String, Double> categoryLimits) {
        super(income, limit, categoryLimits);
    }

    public void generateReport() {
        System.out.println("Annual Summary");
        System.out.println("Yearly Savings: " + netSavings());
    }

    public void detectOverspend() {
        if (totalExpenses() > limit) {
            System.out.println("Annual budget exceeded");
        }
    }
}
