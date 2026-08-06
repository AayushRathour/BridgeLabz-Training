package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthclinic.connection.DBConnection;
import com.healthclinic.model.Department;

public class DepartmentDAO {

	// Add Department
	public void addDepartment(Department department) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "insert into department(department_name) values(?)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, department.getDepartment_name());

			int rows = ps.executeUpdate();

			if(rows > 0) {

				System.out.println("Department Added Successfully.");

			}
			else {

				System.out.println("Department Not Added.");

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


	// View Departments
	public void viewDepartments() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "select * from department";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			System.out.println("ID\tDepartment Name");

			while(rs.next()) {

				System.out.println(

						rs.getInt("department_id")
						+ "\t"
						+ rs.getString("department_name")

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


	// Search Department
	public void searchDepartment(int department_id) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "select * from department where department_id=?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, department_id);

			rs = ps.executeQuery();

			if(rs.next()) {

				System.out.println("\nDepartment Found");

				System.out.println("ID : "
						+ rs.getInt("department_id"));

				System.out.println("Department : "
						+ rs.getString("department_name"));

			}
			else {

				System.out.println("Department Not Found.");

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


	// Update Department
	public void updateDepartment(int department_id, String department_name) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "update department set department_name=? where department_id=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, department_name);

			ps.setInt(2, department_id);

			int rows = ps.executeUpdate();

			if(rows > 0) {

				System.out.println("Department Updated Successfully.");

			}
			else {

				System.out.println("Department Not Found.");

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


	// Delete Department
	public void deleteDepartment(int department_id) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "delete from department where department_id=?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, department_id);

			int rows = ps.executeUpdate();

			if(rows > 0) {

				System.out.println("Department Deleted Successfully.");

			}
			else {

				System.out.println("Department Not Found.");

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


	// Count Departments
	public void countDepartments() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DBConnection.getConnection();

			String sql = "select count(*) as total from department";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			if(rs.next()) {

				System.out.println("Total Departments : "
						+ rs.getInt("total"));

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