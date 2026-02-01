package com.functionalinterfaces.DefaultMethodsinInterfaces;

interface PaymentProcessor {

    void processPayment(double amount);

    default void refund(double amount) {
        System.out.println("Refund processed: " + amount);
    }
}

class Paytm implements PaymentProcessor {

    public void processPayment(double amount) {
        System.out.println("Paytm payment: " + amount);
    }
}

public class PaymentGatewayIntegration {
    public static void main(String[] args) {

        PaymentProcessor p = new Paytm();
        p.processPayment(500);
        p.refund(200);
    }
}
