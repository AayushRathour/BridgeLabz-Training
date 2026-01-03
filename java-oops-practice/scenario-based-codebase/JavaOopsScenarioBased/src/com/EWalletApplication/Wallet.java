package com.EWalletApplication;

public abstract class Wallet implements Transferrable {
    private double balance;

    // normal wallet
    public Wallet() {
        this.balance = 0;
    }

    // wallet with referral bonus
    public Wallet(double referralBonus) {
        this.balance = referralBonus;
    }

    protected void addMoney(double amount) {
        balance += amount;
    }

    protected void deductMoney(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}