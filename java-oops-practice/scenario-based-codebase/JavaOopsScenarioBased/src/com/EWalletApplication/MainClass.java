package com.EWalletApplication;

public class MainClass {
    public static void main(String[] args) {
        Wallet w1 = new PersonalWallet(100);
        Wallet w2 = new BusinessWallet(200);

        User u1 = new User(1, "Aman", w1);
        User u2 = new User(2, "Tarun", w2);

        u1.displayUser();
        u2.displayUser();

        w1.addMoney(500);
        w2.addMoney(1000);

        w1.transferTo(u2, 200);
        w2.transferTo(u1, 300);

        System.out.println("Aman Balance : " + u1.getWallet().getBalance());
        System.out.println("Tarun Balance : " + u2.getWallet().getBalance());
    }
}