package com.EWalletApplication;

public class User {
    private int userId;
    private String name;
    private Wallet wallet;

    public User(int userId, String name, Wallet wallet) {
        this.userId = userId;
        this.name = name;
        this.wallet = wallet;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void displayUser() {
        System.out.println("User Id : " + userId + " Name : " + name);
    }
}