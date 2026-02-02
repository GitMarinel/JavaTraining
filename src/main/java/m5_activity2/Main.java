package m5_activity2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 String url = "jdbc:postgresql://localhost:5432/training_db";
	        String username = "gstmdeleon";
	        String password = "Welcome5%";

	        try {
	            Class.forName("org.postgresql.Driver");

	            Connection conn = DriverManager.getConnection(url, username, password);

	            System.out.println("Connected successfully!");

	            conn.close(); 

	        } catch (SQLException e) {
	            System.out.println("Connection failed: " + e.getMessage());

	        } catch (ClassNotFoundException e) {
	            System.out.println("PostgreSQL Driver not found: " + e.getMessage());
	        }


	}

}
