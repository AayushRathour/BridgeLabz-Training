package com.PayXpressUtilityBillPaymentSystem;

public abstract class Bill {
    private String type;
    protected int amount;
    private int dueDate;
    private boolean isPaid;

    Bill(String type, int amount, int dueDate) {
        this.type = type;
        this.amount = amount;
        this.dueDate = dueDate;
        this.isPaid = false;
    }

    public void applyLateFee(int penalty) {
        amount = amount + penalty;
    }

    protected void markPaid() {
        isPaid = true;
    }

    String getType() {
        return type;
    }

    int getAmount() {
        return amount;
    }

    boolean isPaid() {
        return isPaid;
    }
}
