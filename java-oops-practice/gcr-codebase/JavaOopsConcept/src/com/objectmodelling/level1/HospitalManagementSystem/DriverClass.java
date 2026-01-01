package com.objectmodelling.level1.HospitalManagementSystem;

public class DriverClass {
	public static void main(String[] args) {
	     Doctor doctor = new Doctor("Doctor1");

	     Patient patient = new Patient("Patient1");

	     doctor.addPatient(patient);  

	     // Show consultations
	     doctor.consult(patient);

	     // List all patients for doctors
	     doctor.listPatients();

	     // List all doctors for patients
	     patient.listDoctors();
	}
}