package com.healthclinic.main;

import java.sql.Timestamp;
import java.util.Scanner;

import com.healthclinic.model.Appointment;
import com.healthclinic.model.Department;
import com.healthclinic.model.Doctor;
import com.healthclinic.model.Patient;
import com.healthclinic.service.AppointmentService;
import com.healthclinic.service.DepartmentService;
import com.healthclinic.service.DoctorService;
import com.healthclinic.service.PatientService;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		PatientService patientService = new PatientService();
		DoctorService doctorService = new DoctorService();
		DepartmentService departmentService = new DepartmentService();
		AppointmentService appointmentService = new AppointmentService();

		while(true) {
			System.out.println("\nHEALTH CLINIC MANAGEMENT SYSTEM");

			System.out.println("1 Add Patient");
			System.out.println("2 View Patients");
			System.out.println("3 Search Patient");
			System.out.println("4 Update Patient");
			System.out.println("5 Delete Patient");
			System.out.println("6 Count Patients");
			System.out.println("7 Add Doctor");
			System.out.println("8 View Doctors");
			System.out.println("9 Search Doctor");
			System.out.println("10 Update Doctor Fee");
			System.out.println("11 Delete Doctor");
			System.out.println("12 Add Department");
			System.out.println("13 View Departments");
			System.out.println("14 Book Appointment");
			System.out.println("15 View Appointments");
			System.out.println("16 Update Appointment Status");
			System.out.println("17 Delete Appointment");
			System.out.println("18 Appointment Report");
			System.out.println("19 Visit History");
			System.out.println("20 Generate Bill");
			System.out.println("21 Exit");
			System.out.print("\nEnter Your Choice : ");

			int choice = sc.nextInt();

			switch(choice) {

			case 1:

				System.out.print("\nEnter Patient ID : ");
				int pat_id = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Patient Name : ");
				String pat_name = sc.nextLine();

				System.out.print("Enter Patient Phone : ");
				String pat_phone = sc.nextLine();

				Patient patient = new Patient(pat_id, pat_name, pat_phone);

				patientService.addPatient(patient);

				break;

			case 2:

				patientService.viewPatients();

				break;

			case 3:

				System.out.print("\nEnter Patient ID : ");

				int searchId = sc.nextInt();

				patientService.searchPatient(searchId);

				break;

			case 4:

				System.out.print("\nEnter Patient ID : ");

				int updateId = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter New Phone Number : ");

				String newPhone = sc.nextLine();

				patientService.updatePatient(updateId, newPhone);

				break;

			case 5:

				System.out.print("\nEnter Patient ID : ");

				int deleteId = sc.nextInt();

				patientService.deletePatient(deleteId);

				break;

			case 6:

				patientService.countPatients();

				break;

			case 7:

				System.out.print("\nEnter Doctor ID : ");
				int doc_id = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Doctor Name : ");
				String doc_name = sc.nextLine();

				System.out.print("Enter Speciality : ");
				String doc_speciality = sc.nextLine();

				System.out.print("Enter Department ID : ");
				int doc_department_id = sc.nextInt();

				System.out.print("Enter Fee : ");
				int doc_fee = sc.nextInt();

				Doctor doctor = new Doctor(doc_id, doc_name, doc_speciality, doc_department_id, doc_fee);

				doctorService.addDoctor(doctor);

				break;

			case 8:

				doctorService.viewDoctors();

				break;

			case 9:

				System.out.print("\nEnter Doctor ID : ");

				int searchDocId = sc.nextInt();

				doctorService.searchDoctor(searchDocId);

				break;

			case 10:

				System.out.print("\nEnter Doctor ID : ");

				int feeDocId = sc.nextInt();

				System.out.print("Enter New Fee : ");

				double newFee = sc.nextDouble();

				doctorService.updateDoctorFee(feeDocId, newFee);

				break;

			case 11:

				System.out.print("\nEnter Doctor ID : ");

				int deleteDocId = sc.nextInt();

				doctorService.deleteDoctor(deleteDocId);

				break;

			case 12:

				sc.nextLine();

				System.out.print("\nEnter Department Name : ");
				String department_name = sc.nextLine();

				Department department = new Department(0, department_name);

				departmentService.addDepartment(department);

				break;

			case 13:

				departmentService.viewDepartments();

				break;

			case 14:

				System.out.print("\nEnter Appointment ID : ");
				int appoint_id = sc.nextInt();

				System.out.print("Enter Patient ID : ");
				int appoint_pat_id = sc.nextInt();

				System.out.print("Enter Doctor ID : ");
				int appoint_doc_id = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Appointment Date (yyyy-MM-dd HH:mm:ss) : ");
				String dateInput = sc.nextLine();
				Timestamp appoint_date = Timestamp.valueOf(dateInput);

				System.out.print("Enter Status (Scheduled / Completed / Cancelled) : ");
				String appoint_status = sc.nextLine();

				Appointment appointment = new Appointment(appoint_id, appoint_pat_id, appoint_doc_id, appoint_date, appoint_status);

				appointmentService.addAppointment(appointment);

				break;

			case 15:

				appointmentService.viewAppointments();

				break;

			case 16:

				System.out.print("\nEnter Appointment ID : ");
				int statusAppointId = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter New Status : ");
				String newStatus = sc.nextLine();

				appointmentService.updateAppointmentStatus(statusAppointId, newStatus);

				break;

			case 17:

				System.out.print("\nEnter Appointment ID : ");
				int deleteAppointId = sc.nextInt();

				appointmentService.deleteAppointment(deleteAppointId);

				break;

			case 18:

				appointmentService.viewAppointmentReport();

				break;

			case 19:

				appointmentService.viewVisitHistory();

				break;

			case 20:

				System.out.print("\nEnter Appointment ID : ");
				int billAppointId = sc.nextInt();

				appointmentService.generateBill(billAppointId);

				break;

			case 21:

				System.out.println("\nThank You...");
				System.out.println("Project Closed Successfully.");

				sc.close();

				System.exit(0);

				break;

			default:

				System.out.println("\nInvalid Choice...");

			}

		}

	}

}
