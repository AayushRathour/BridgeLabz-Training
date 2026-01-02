package com.HospitalPatientManagementSystem;

public class MainClass {
    public static void main(String[] args) {
        Patient p1 = new Inpatient(1, "Aayush", 5);
        Patient p2 = new Outpatient(2, "Harsh", 3);

        Doctor d1 = new Doctor(0, "Doctor", "Dept");

        Bill bill = new Bill(20000);

        p1.displayInfo();
        p2.displayInfo();
        d1.displayInfo();

        System.out.println("Total Bill : " + bill.calculatePayment());
    }
}