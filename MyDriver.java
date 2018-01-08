package SpellChecker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDriver {

	private static Connection myConn;
	
/** Java DataBase Connectivity
 * <p>
 * jdbcConnection establishes a connection with the MySQL database that the other methods like existsInDictionary and findSuggestions use.
 * jdbcConnection needs the username and password of the administrator of MySQL, and therefore the user is asked to insert them.
 * 
 * @param username
 * @param password
 */
	public static void jdbcConnection(String username, String password) throws SQLException {
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/dictionary?useSSL=false";
			myConn = DriverManager.getConnection(url, username, password);
			Word.myConn = myConn;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
