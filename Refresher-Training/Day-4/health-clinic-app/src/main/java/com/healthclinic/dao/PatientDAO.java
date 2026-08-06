package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthclinic.connection.DBConnection;
import com.healthclinic.model.Patient;

public class PatientDAO {

	// Add Patient
	public void addPatient(Patient patient) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "insert into patient(pat_id, pat_name, pat_phone) values(?,?,?)";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, patient.getPat_id());
			ps.setString(2, patient.getPat_name());
			ps.setString(3, patient.getPat_phone());

			int rows = ps.executeUpdate();

			if(rows > 0) {

				System.out.println("\nPatient Added Successfully.");

			}
			else {

				System.out.println("\nPatient Not Added.");

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



	// View All Patients
	public void viewPatients() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "select * from patient";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			System.out.println("ID\tName\t\tPhone");

			while(rs.next()) {

				System.out.println(

						rs.getInt("pat_id")
						+ "\t"
						+ rs.getString("pat_name")
						+ "\t"
						+ rs.getString("pat_phone")

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



	// Search Patient
	public void searchPatient(int pat_id) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "select * from patient where pat_id=?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, pat_id);

			rs = ps.executeQuery();

			if(rs.next()) {

				System.out.println("\nPatient Found");

				System.out.println("ID : " + rs.getInt("pat_id"));
				System.out.println("Name : " + rs.getString("pat_name"));
				System.out.println("Phone : " + rs.getString("pat_phone"));

			}

			else {

				System.out.println("\nPatient Not Found.");

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



	// Update Patient
	public void updatePatient(int pat_id, String phone) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "update patient set pat_phone=? where pat_id=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, phone);
			ps.setInt(2, pat_id);

			int rows = ps.executeUpdate();

			if(rows > 0) {

				System.out.println("\nPatient Updated Successfully.");

			}

			else {

				System.out.println("\nPatient Not Found.");

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



	// Delete Patient
	public void deletePatient(int pat_id) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "delete from patient where pat_id=?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, pat_id);

			int rows = ps.executeUpdate();

			if(rows > 0) {

				System.out.println("\nPatient Deleted Successfully.");

			}

			else {

				System.out.println("\nPatient Not Found.");

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



	// Count Patients
	public void countPatients() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "select count(*) as total from patient";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			if(rs.next()) {

				System.out.println("\nTotal Patients : " + rs.getInt("total"));

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