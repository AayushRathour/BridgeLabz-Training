package com.encapsulationandpolymorphism.HospitalPatientManagement;

public class OutPatient extends Patient {
    // constructor
    public OutPatient(int patientId, String name, int age) {
        super(patientId, name, age);
    }

    public int calculateBill() {
        return 1000;
    }

    public void addRecord(String record) {
        System.out.println("OutPatient record added");
    }

    public void viewRecords() {
        System.out.println("OutPatient records");
    }
}