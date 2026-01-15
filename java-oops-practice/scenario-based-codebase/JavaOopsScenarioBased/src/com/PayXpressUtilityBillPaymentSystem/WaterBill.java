package com.PayXpressUtilityBillPaymentSystem;

public class WaterBill extends Bill implements IPayable {

    WaterBill(int amount, int dueDate) {
        super("Water", amount, dueDate);
    }

    public void pay() {
        markPaid();
        System.out.println("Water bill paid");
    }

    public void sendReminder() {
        System.out.println("Water bill reminder sent");
    }
}
