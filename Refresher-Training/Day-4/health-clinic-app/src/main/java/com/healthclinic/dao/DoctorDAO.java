package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthclinic.connection.DBConnection;
import com.healthclinic.model.Doctor;

public class DoctorDAO {

	// Add Doctor
	public void addDoctor(Doctor doctor) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "insert into doctor(doc_id, doc_name, doc_speciality, department_id, doc_fee) values(?,?,?,?,?)";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, doctor.getDoc_id());
			ps.setString(2, doctor.getDoc_name());
			ps.setString(3, doctor.getDoc_Speciality());
			ps.setInt(4, doctor.getDepartment_id());
			ps.setDouble(5, doctor.getDoc_fee());

			int rows = ps.executeUpdate();

			if(rows > 0) {

				System.out.println("Doctor Added Successfully...");

			}
			else {

				System.out.println("Doctor Not Added.");

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

	// View Doctors
	public void viewDoctors() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "select * from doctor";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			System.out.println("\n---------------------------------------------------------------");
			System.out.println("ID\tName\t\tSpeciality\tDepartment\tFee");
			System.out.println("---------------------------------------------------------------");

			while(rs.next()) {

				System.out.println(

						rs.getInt("doc_id") + "\t"

						+ rs.getString("doc_name") + "\t"

						+ rs.getString("doc_speciality") + "\t"

						+ rs.getInt("department_id") + "\t\t"

						+ rs.getDouble("doc_fee")

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

	// Search Doctor
	public void searchDoctor(int doc_id) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "select * from doctor where doc_id=?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, doc_id);

			rs = ps.executeQuery();

			if(rs.next()) {

				System.out.println("\nDoctor Found");
				System.out.println("--------------------------");

				System.out.println("ID : " + rs.getInt("doc_id"));
				System.out.println("Name : " + rs.getString("doc_name"));
				System.out.println("Speciality : " + rs.getString("doc_speciality"));
				System.out.println("Department : " + rs.getInt("department_id"));
				System.out.println("Fee : " + rs.getDouble("doc_fee"));

			}
			else {

				System.out.println("Doctor Not Found.");

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

	// Update Doctor Fee
	public void updateDoctorFee(int doc_id, double fee) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "update doctor set doc_fee=? where doc_id=?";

			ps = conn.prepareStatement(sql);

			ps.setDouble(1, fee);
			ps.setInt(2, doc_id);

			int rows = ps.executeUpdate();

			if(rows > 0) {

				System.out.println("Doctor Fee Updated Successfully.");

			}
			else {

				System.out.println("Doctor Not Found.");

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

	// Delete Doctor
	public void deleteDoctor(int doc_id) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "delete from doctor where doc_id=?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, doc_id);

			int rows = ps.executeUpdate();

			if(rows > 0) {

				System.out.println("Doctor Deleted Successfully.");

			}
			else {

				System.out.println("Doctor Not Found.");

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

	// Count Doctors
	public void countDoctors() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "select count(*) as total from doctor";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			if(rs.next()) {

				System.out.println("Total Doctors : " + rs.getInt("total"));

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