package practice.HospitalManagementSystem;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException; 
public class Utility { 
	
	private static final String url = "jdbc:mysql://localhost:3306/hospitalmanagementsystems";
	private static final String username = "root";
	private static final String password = "7509";
	
	static {
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		}
		catch (Exception e) { 
			System.out.println(e.getMessage()); 
			} 
		} 
	
	public static Connection getConnection() { 
		try {
			return DriverManager.getConnection(url, username, password); 
		} 
		catch (SQLException e) { 
			System.out.println(e.getMessage()); return null;
		}
	}
}
