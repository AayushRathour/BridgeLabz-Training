package com.EWalletApplication;

public class BusinessWallet extends Wallet {
    private double taxRate = 0.02;

    public BusinessWallet(double referralBonus) {
        super(referralBonus);
    }

    public void transferTo(User receiver, double amount) {
        double tax = amount * taxRate;
        double total = amount + tax;

        if(getBalance() < total) {
            System.out.println("Insufficient balance");
            return;
        }
        deductMoney(total);
        receiver.getWallet().addMoney(amount);
    }
}