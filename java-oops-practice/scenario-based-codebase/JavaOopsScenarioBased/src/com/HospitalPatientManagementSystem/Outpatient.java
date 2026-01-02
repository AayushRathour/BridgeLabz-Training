package com.HospitalPatientManagementSystem;

public class Outpatient extends Patient {
    private int visitCount;

    public Outpatient(int patientId, String name, int visitCount) {
        super(patientId, name);
        this.visitCount = visitCount;
    }

    public void displayInfo() {
        System.out.println(getSummary() + " OutPatient Visits : " + visitCount);
    }

    public int getVisitCount() {
        return visitCount;
    }
}