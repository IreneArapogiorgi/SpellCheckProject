package spellchecker;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//imports classes to be used in connection with database

public class Word {

	// class variables

	private String word;

	public boolean isSpelledCorrectly;

	public String[] bestPossibleSolutions = new String[3];

	private String dividingChars;	
	public Word(String inputWord, String dividingChars) throws SQLException { // class constructor
		this.word = inputWord; // what the user wrote
		this.dividingChars = dividingChars; // non-letter characters following the word
		this.isSpelledCorrectly = existsInDictionary();
		if (this.isSpelledCorrectly = false)
			this.findSuggestions(); // initial value to be changed through findSuggestions
		}
	public static boolean isΑNumber(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}
	public boolean existsInDictionary() throws SQLException {
		try {
			if (isΑNumber(word)) {
				this.isSpelledCorrectly = true;
			}
			String url = "jdbc:mysql://127.0.0.1:3306/javadics?useSSL=false";
			Connection myConn = DriverManager.getConnection(url, "root", "george");
			CallableStatement cStmt = myConn.prepareCall("{call existsindictionary(?)}");
			cStmt.setString(1, this.word);
			cStmt.execute();
			if (cStmt.getResultSet().next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public void findSuggestions() throws SQLException{
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/javadics?useSSL=false";
			Connection myConn = DriverManager.getConnection(url, "root", "george");
			CallableStatement cStmt = myConn.prepareCall("{call findsuggestions(?)}");
			cStmt.setString(1, this.word);
			cStmt.execute();
			ResultSet rs = cStmt.getResultSet();
			String[] str = new String[3];
			int i = 0;
			while (rs.next()) {
			//bestPossibleSolutions[i] = rs.getString(i + 1);
			str[i] = rs.getString(1);
			i ++;
			}
			bestPossibleSolutions = str;
			rs.close();
			cStmt.close();
			myConn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
	}

	}

}
