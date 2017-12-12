package Heh; 
import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		try {
			// I will connect to MySQL database with Java
			
			// 1. Getting connection to database
			Connection myConn = 
					DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/languages", "AngelG", "SnowWhite");
			// 2. Creating a statement
			Statement myStat = myConn.createStatement();
			// 3. Execution of SQL Query
					ResultSet myRs = myStat.executeQuery("select * from animals");
			// 4. Process the result set
							while (myRs.next()) {
								System.out.println(myRs.getString("name"));
							}
		} catch (Exception ex) {
			ex.printStackTrace();	
		} 
	} 

}
