package com.constructor.level1;

public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public int getTotalPrice() {
        return rentalDays * 100;
    }

    public static void main(String[] args) {
        CarRental car = new CarRental("Customer1", "Model1", 10);
        System.out.println(car.getTotalPrice());
    }
}
