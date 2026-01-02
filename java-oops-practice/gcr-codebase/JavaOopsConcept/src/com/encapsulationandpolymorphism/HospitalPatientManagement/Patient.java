package com.encapsulationandpolymorphism.HospitalPatientManagement;

public abstract class Patient implements MedicalRecord {
    private int patientId;
    private String name;
    private int age;
    private String medicalHistory;

    // constructor
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = "Protected";
    }

    // abstract method
    public abstract int calculateBill();

    // concrete method
    public void getPatientDetails() {
        System.out.println(patientId + " " + name + " age : " + age);
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }
}