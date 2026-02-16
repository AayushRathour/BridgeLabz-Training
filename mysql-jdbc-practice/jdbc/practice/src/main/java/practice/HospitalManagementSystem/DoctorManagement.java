package practice.HospitalManagementSystem;

import java.sql.*;
import java.util.Scanner;

public class DoctorManagement {

    public static void main(String[] args) throws Exception {

        Connection con = Utility.getConnection();
        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("\n1.Add Doctor  2.Update Specialty  3.View by Specialty  4.Deactivate  5.Exit");
            int ch = sc.nextInt();
            sc.nextLine();

            if(ch==1){
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Contact: ");
                String contact = sc.nextLine();
                System.out.print("Fee: ");
                double fee = sc.nextDouble();
                System.out.print("Specialty ID: ");
                int sid = sc.nextInt();

                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO doctor(name,contact,consultation_fee,specialty_id) VALUES(?,?,?,?)");
                ps.setString(1,name);
                ps.setString(2,contact);
                ps.setDouble(3,fee);
                ps.setInt(4,sid);
                ps.executeUpdate();
                System.out.println("Doctor Added");
            }

            else if(ch==2){
                System.out.print("Doctor ID: ");
                int did = sc.nextInt();
                System.out.print("New Specialty ID: ");
                int sid = sc.nextInt();

                con.prepareStatement(
                        "UPDATE doctor SET specialty_id="+sid+" WHERE id="+did)
                        .executeUpdate();
                System.out.println("Updated");
            }

            else if(ch==3){
                System.out.print("Specialty Name: ");
                String sname = sc.nextLine();

                PreparedStatement ps = con.prepareStatement(
                        "SELECT d.id,d.name FROM doctor d JOIN specialty s " +
                        "ON d.specialty_id=s.id WHERE s.name=? AND d.is_active=TRUE");
                ps.setString(1,sname);

                ResultSet rs = ps.executeQuery();
                while(rs.next())
                    System.out.println(rs.getInt(1)+" "+rs.getString(2));
            }

            else if(ch==4){
                System.out.print("Doctor ID: ");
                int did = sc.nextInt();

                ResultSet rs = con.prepareStatement(
                        "SELECT COUNT(*) FROM appointment WHERE doctor_id="+did+
                                " AND appointment_date>=CURDATE()")
                        .executeQuery();
                rs.next();

                if(rs.getInt(1)>0)
                    System.out.println("Has future appointments");
                else{
                    con.prepareStatement(
                            "UPDATE doctor SET is_active=FALSE WHERE id="+did)
                            .executeUpdate();
                    System.out.println("Deactivated");
                }
            }

            else break;
        }

        con.close();
    }
}
