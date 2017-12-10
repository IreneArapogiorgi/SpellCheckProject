import java.sql.*;

public class DBConnection {
	private Connection con = null;

	//settings for db connection

	private final String url = "jdbc:mysql://195.251.249.131:3306/ismgroup8";
	private final String dbusername = "ismgroup8";
	private final String dbpassword = "mpu5vv";

	//method to get connection
	public Connection getConnection() {
		return this.con;
	}

	public void open() throws SQLException {
		//load the drivers class file into memory
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch(ClassNotFoundException e) {
			System.out.println("Class not found");
		} catch(IllegalAccessException e) {
		   	System.out.println("Access problem");
		} catch(InstantiationException e) {
		   	System.out.println("Cant create this instance");
		}

		try {
			//make connection with db

			con = DriverManager.getConnection(url, dbusername, dbpassword);
		} catch (Exception e) {
			throw new SQLException("Could not establish connection with the Database Server :" + e.getMessage());
		}
	}

	public void close() throws SQLException {
		try {
			if (con != null)//if there is connection
				con.close();
		} catch (Exception e) {
			throw new SQLException("Could not close the connection: "+ e.getMessage());
		}
	}
}