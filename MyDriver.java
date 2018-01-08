package SpellChecker;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyDriver {

	private static Connection myConn;

	public static void jdbcConnection() {
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/javadics?useSSL=false";
			String username = "root"; // here you will write the username of the MySQL connection
			String password = "SnowWhite"; // here you will write the password of the MySQL connection
			myConn = DriverManager.getConnection(url, username, password);
			Word.myConn = myConn;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
