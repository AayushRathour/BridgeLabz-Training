package com.PayXpressUtilityBillPaymentSystem;

public class ElectricityBill extends Bill implements IPayable {

    ElectricityBill(int amount, int dueDate) {
        super("Electricity", amount, dueDate);
    }

    public void pay() {
        markPaid();
        System.out.println("Electricity bill paid");
    }

    public void sendReminder() {
        System.out.println("Electricity bill due soon");
    }
}
