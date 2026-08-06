package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthclinic.connection.DBConnection;
import com.healthclinic.model.Appointment;

public class AppointmentDAO {

	// Book Appointment
	public void addAppointment(Appointment appointment) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "insert into appointment(pat_id, doc_id, appoint_date, status) values(?,?,?,?)";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, appointment.getPat_id());
			ps.setInt(2, appointment.getDoc_id());
			ps.setTimestamp(3, appointment.getAppoint_date());
			ps.setString(4, appointment.getStatus());

			int rows = ps.executeUpdate();

			if(rows > 0) {

				System.out.println("Appointment Booked Successfully.");

			}
			else {

				System.out.println("Appointment Not Booked.");

			}

		}

		catch(SQLException e) {

			e.printStackTrace();

		}

		finally {

			try {

				if(ps != null)
					ps.close();

				if(conn != null)
					conn.close();

			}

			catch(SQLException e) {

				e.printStackTrace();

			}

		}

	}


	// View All Appointments
	public void viewAppointments() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "select * from appointment";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			System.out.println("ID\tPatient\tDoctor\tDate\t\t\tStatus");

			while(rs.next()) {

				System.out.println(

						rs.getInt("appoint_id") + "\t"
						+ rs.getInt("pat_id") + "\t"
						+ rs.getInt("doc_id") + "\t"
						+ rs.getString("appoint_date") + "\t"
						+ rs.getString("status")

				);

			}

		}

		catch(SQLException e) {

			e.printStackTrace();

		}

		finally {

			try {

				if(rs != null)
					rs.close();

				if(ps != null)
					ps.close();

				if(conn != null)
					conn.close();

			}

			catch(SQLException e) {

				e.printStackTrace();

			}

		}

	}


	// Search Appointment
	public void searchAppointment(int appoint_id) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "select * from appointment where appoint_id=?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, appoint_id);

			rs = ps.executeQuery();

			if(rs.next()) {

				System.out.println("\nAppointment Found");

				System.out.println("------------------------------");

				System.out.println("Appointment ID : " + rs.getInt("appoint_id"));
				System.out.println("Patient ID : " + rs.getInt("pat_id"));
				System.out.println("Doctor ID : " + rs.getInt("doc_id"));
				System.out.println("Date : " + rs.getString("appoint_date"));
				System.out.println("Status : " + rs.getString("status"));

			}
			else {

				System.out.println("Appointment Not Found.");

			}

		}

		catch(SQLException e) {

			e.printStackTrace();

		}

		finally {

			try {

				if(rs != null)
					rs.close();

				if(ps != null)
					ps.close();

				if(conn != null)
					conn.close();

			}

			catch(SQLException e) {

				e.printStackTrace();

			}

		}

	}
	// Update Appointment Status
	public void updateAppointmentStatus(int appoint_id, String status) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "update appointment set status=? where appoint_id=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, status);
			ps.setInt(2, appoint_id);

			int rows = ps.executeUpdate();

			if(rows > 0) {

				System.out.println("Appointment Updated Successfully.");

			}
			else {

				System.out.println("Appointment Not Found.");

			}

		}

		catch(SQLException e) {

			e.printStackTrace();

		}

		finally {

			try {

				if(ps != null)
					ps.close();

				if(conn != null)
					conn.close();

			}

			catch(SQLException e) {

				e.printStackTrace();

			}

		}

	}


	// Delete Appointment
	public void deleteAppointment(int appoint_id) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "delete from appointment where appoint_id=?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, appoint_id);

			int rows = ps.executeUpdate();

			if(rows > 0) {

				System.out.println("Appointment Deleted Successfully.");

			}
			else {

				System.out.println("Appointment Not Found.");

			}

		}

		catch(SQLException e) {

			e.printStackTrace();

		}

		finally {

			try {

				if(ps != null)
					ps.close();

				if(conn != null)
					conn.close();

			}

			catch(SQLException e) {

				e.printStackTrace();

			}

		}

	}

	// View Appointment Report using JOIN
	public void viewAppointmentReport() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DBConnection.getConnection();

			String sql =
			"select a.appoint_id, p.pat_name, d.doc_name, d.doc_speciality, a.appoint_date, a.status " +
			"from appointment a " +
			"join patient p on a.pat_id = p.pat_id " +
			"join doctor d on a.doc_id = d.doc_id";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			System.out.println("ID\tPatient\t\tDoctor\t\tSpeciality\tStatus");

			while(rs.next()) {

				System.out.println(

						rs.getInt("appoint_id") + "\t"

						+ rs.getString("pat_name") + "\t"

						+ rs.getString("doc_name") + "\t"

						+ rs.getString("doc_speciality") + "\t"

						+ rs.getString("status")

				);

			}

		}

		catch(SQLException e) {

			e.printStackTrace();

		}

		finally {

			try {

				if(rs != null)
					rs.close();

				if(ps != null)
					ps.close();

				if(conn != null)
					conn.close();

			}

			catch(SQLException e) {

				e.printStackTrace();

			}

		}

	}
	// View Visit History
	public void viewVisitHistory() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DBConnection.getConnection();

			String sql =
			"select p.pat_name,d.doc_name,d.doc_speciality,a.appoint_date,a.status "
			+ "from appointment a "
			+ "join patient p on a.pat_id=p.pat_id "
			+ "join doctor d on a.doc_id=d.doc_id";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			System.out.println("\nVisit History");

			while(rs.next()) {

				System.out.println(

				rs.getString("pat_name")

				+ " | "

				+ rs.getString("doc_name")

				+ " | "

				+ rs.getString("doc_speciality")

				+ " | "

				+ rs.getTimestamp("appoint_date")

				+ " | "

				+ rs.getString("status")

				);

			}

		}
		catch(SQLException e) {

			e.printStackTrace();

		}

		finally {

			try {

				if(rs != null)
					rs.close();

				if(ps != null)
					ps.close();

				if(conn != null)
					conn.close();

			}

			catch(SQLException e) {

				e.printStackTrace();

			}

		}

	}
	// Generate Bill

	public void generateBill(int appoint_id) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DBConnection.getConnection();

			String sql =
			"select p.pat_name,d.doc_name,d.doc_fee "
			+ "from appointment a "
			+ "join patient p on a.pat_id=p.pat_id "
			+ "join doctor d on a.doc_id=d.doc_id "
			+ "where appoint_id=?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, appoint_id);

			rs = ps.executeQuery();

			if(rs.next()) {

				double fee = rs.getDouble("doc_fee");

				double gst = fee * 0.18;

				double total = fee + gst;

				System.out.println("Patient : " + rs.getString("pat_name"));

				System.out.println("Doctor  : " + rs.getString("doc_name"));

				System.out.println("Fee     : " + fee);

				System.out.println("GST     : " + gst);

				System.out.println("Total   : " + total);
			}

		}
		catch(SQLException e) {

			e.printStackTrace();

		}

		finally {

			try {

				if(rs != null)
					rs.close();

				if(ps != null)
					ps.close();

				if(conn != null)
					conn.close();

			}

			catch(SQLException e) {

				e.printStackTrace();

			}

		}

	}

}