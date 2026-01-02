package com.encapsulationandpolymorphism.HospitalPatientManagement;

public class InPatient extends Patient {
    private int daysAdmitted;

    // constructor
    public InPatient(int patientId, String name, int age, int daysAdmitted) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
    }

    public int calculateBill() {
        return daysAdmitted * 1000;
    }
    
    // method to add record
    public void addRecord(String record) {
        System.out.println("InPatient record added");
    }

    public void viewRecords() {
        System.out.println("InPatient records");
    }
}