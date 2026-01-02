package com.HospitalPatientManagementSystem;

public class Bill implements Payable {
    private int baseAmount;
    private int tax;
    private int discount;

    public Bill(int baseAmount) {
        this.baseAmount = baseAmount;
        this.tax = baseAmount * 5 / 100;
        this.discount = baseAmount * 10 / 100;
    }

    public int calculatePayment() {
        return baseAmount + tax - discount;
    }
}