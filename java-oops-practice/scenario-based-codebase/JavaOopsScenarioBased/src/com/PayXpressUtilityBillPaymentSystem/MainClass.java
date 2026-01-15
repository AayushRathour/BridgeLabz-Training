package com.PayXpressUtilityBillPaymentSystem;

public class MainClass {
    public static void main(String[] args) {

        Bill b1 = new ElectricityBill(500, 10);
        Bill b2 = new InternetBill(800, 5);
        Bill b3 = new WaterBill(300, 7);

        b1.applyLateFee(50);

        ((IPayable)b1).sendReminder();
        ((IPayable)b2).sendReminder();
        ((IPayable)b3).sendReminder();

        ((IPayable)b1).pay();
    }
}
