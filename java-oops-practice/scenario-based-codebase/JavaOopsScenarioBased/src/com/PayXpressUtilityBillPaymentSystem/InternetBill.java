package com.PayXpressUtilityBillPaymentSystem;

public class InternetBill extends Bill implements IPayable {

    InternetBill(int amount, int dueDate) {
        super("Internet", amount, dueDate);
    }

    public void pay() {
        markPaid();
        System.out.println("Internet bill paid");
    }

    public void sendReminder() {
        System.out.println("Internet service will be suspended if unpaid");
    }
}
