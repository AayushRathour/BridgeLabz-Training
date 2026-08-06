package com.healthclinic.service;

import com.healthclinic.dao.AppointmentDAO;
import com.healthclinic.model.Appointment;

// Appointment Service Class

public class AppointmentService {

	AppointmentDAO dao = new AppointmentDAO();

	// Book Appointment
	public void addAppointment(Appointment appointment) {
		dao.addAppointment(appointment);
	}

	// View Appointments
	public void viewAppointments() {
		dao.viewAppointments();
	}

	// Search Appointment
	public void searchAppointment(int appoint_id) {
		dao.searchAppointment(appoint_id);
	}

	// Update Appointment Status
	public void updateAppointmentStatus(int appoint_id, String status) {
		dao.updateAppointmentStatus(appoint_id, status);
	}

	// Delete Appointment
	public void deleteAppointment(int appoint_id) {
		dao.deleteAppointment(appoint_id);
	}

	// Appointment Report
	public void viewAppointmentReport() {
		dao.viewAppointmentReport();
	}
	// Visit History
	public void viewVisitHistory() {

		dao.viewVisitHistory();

	}
	// Generates Bill 
	public void generateBill(int appoint_id) {

		dao.generateBill(appoint_id);

	}

}