package com.EWalletApplication;

public class PersonalWallet extends Wallet {
    public PersonalWallet(double referralBonus) {
        super(referralBonus);
    }

    public void transferTo(User receiver, double amount) {
        if(getBalance() < amount) {
            System.out.println("Insufficient balance");
            return;
        }
        
        deductMoney(amount);
        receiver.getWallet().addMoney(amount);
    }
}