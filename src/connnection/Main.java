package connnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//프로젝트 우클릭 - build path - class-path - add External jar - oracleDB폴더에 jdbcjar 선택
public class Main {
	 static final String DB_URL = "jdbc:oracle:thin:@192.168.0.22:1521:XE";
	   static final String USER = "syd";
	   static final String PASS = "syd1234";
	   static final String QUERY = "SELECT id, BRAND, COLOR, MODEL FROM CAR";

	   public static void main(String[] args) throws SQLException,ClassNotFoundException {
		  
		   
		 DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		 Class.forName("oracle.jdbc.OracleDriver");
		 
		   
	      // Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(QUERY);) {
	         // Extract data from result set
	         while (rs.next()) {
	            // Retrieve by column name
	            System.out.print("ID: " + rs.getInt("id"));
	            System.out.print(", BRAND: " + rs.getString("BRAND"));
	            System.out.print(", COLOR: " + rs.getString("COLOR"));
	            System.out.println(", MODEL: " + rs.getString("MODEL"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	   }
	
	

}
