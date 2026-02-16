package practice.HospitalManagementSystem;

import java.sql.*;
import java.util.*;

public class SystemAdministration {

    public static void main(String[] args) throws Exception {

        Connection con = Utility.getConnection();
        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("\n1.Specialty CRUD  2.Backup  3.View Audit Logs  4.Exit");
            int ch = sc.nextInt();
            sc.nextLine();

            // UC-6.1 Manage Specialty
            if(ch==1){

                System.out.println("1.Add  2.Update  3.Delete  4.View");
                int op = sc.nextInt();
                sc.nextLine();

                if(op==1){
                    System.out.print("Specialty Name: ");
                    String name = sc.nextLine();
                    PreparedStatement ps = con.prepareStatement(
                            "INSERT INTO specialty(name) VALUES(?)");
                    ps.setString(1,name);
                    ps.executeUpdate();
                    System.out.println("Added");
                }

                else if(op==2){
                    System.out.print("Specialty ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String name = sc.nextLine();

                    PreparedStatement ps = con.prepareStatement(
                            "UPDATE specialty SET name=? WHERE id=?");
                    ps.setString(1,name);
                    ps.setInt(2,id);
                    ps.executeUpdate();
                    System.out.println("Updated");
                }

                else if(op==3){
                    System.out.print("Specialty ID: ");
                    int id = sc.nextInt();

                    PreparedStatement check = con.prepareStatement(
                            "SELECT COUNT(*) FROM doctor WHERE specialty_id=?");
                    check.setInt(1,id);
                    ResultSet rs = check.executeQuery();
                    rs.next();

                    if(rs.getInt(1)>0)
                        System.out.println("Cannot delete. Doctors assigned.");
                    else{
                        PreparedStatement del = con.prepareStatement(
                                "DELETE FROM specialty WHERE id=?");
                        del.setInt(1,id);
                        del.executeUpdate();
                        System.out.println("Deleted");
                    }
                }

                else{
                    ResultSet rs = con.createStatement()
                            .executeQuery("SELECT * FROM specialty");
                    while(rs.next())
                        System.out.println(rs.getInt(1)+" "+rs.getString(2));
                }
            }

            // UC-6.2 Database Backup (Simple Export)
            else if(ch==2){

                DatabaseMetaData meta = con.getMetaData();
                ResultSet tables = meta.getTables(null,null,"%",new String[]{"TABLE"});

                while(tables.next()){
                    String table = tables.getString("TABLE_NAME");
                    System.out.println("Backing up: "+table);

                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM "+table);

                    ResultSetMetaData rsMeta = rs.getMetaData();
                    int cols = rsMeta.getColumnCount();

                    while(rs.next()){
                        for(int i=1;i<=cols;i++)
                            System.out.print(rs.getString(i)+" | ");
                        System.out.println();
                    }
                }

                System.out.println("Backup Complete (Console Export)");
            }

            // UC-6.3 View Audit Logs
            else if(ch==3){

                System.out.print("User (or press Enter): ");
                String user = sc.nextLine();

                System.out.print("Table Name (or press Enter): ");
                String table = sc.nextLine();

                System.out.print("From Date (YYYY-MM-DD): ");
                String from = sc.nextLine();

                System.out.print("To Date (YYYY-MM-DD): ");
                String to = sc.nextLine();

                String query =
                        "SELECT * FROM audit_log WHERE 1=1 ";

                if(!user.isEmpty())
                    query += "AND user_name='"+user+"' ";
                if(!table.isEmpty())
                    query += "AND table_name='"+table+"' ";
                if(!from.isEmpty() && !to.isEmpty())
                    query += "AND action_time BETWEEN '"+from+"' AND '"+to+"' ";

                ResultSet rs = con.createStatement().executeQuery(query);

                while(rs.next())
                    System.out.println(
                            rs.getInt("id")+" | "+
                            rs.getString("user_name")+" | "+
                            rs.getString("table_name")+" | "+
                            rs.getString("action")+" | "+
                            rs.getTimestamp("action_time"));
            }

            else break;
        }

        con.close();
    }
}
