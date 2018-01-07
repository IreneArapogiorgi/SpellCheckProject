package SpellChecker;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//imports classes to be used in connection with database

public class Word {

	// class variables

	private static int index; // number of word orderly in the sentence

	private int count;

	private String word;

	private boolean isSpelledCorrectly;

	private String[] bestPossibleSolutions = new String[3];

	private String dividingChars;

	public Word(String inputWord, String dividingChars) throws SQLException { // class constructor
		this.count = ++index;
		this.word = inputWord; // what the user wrote
		this.dividingChars = dividingChars; // non-letter characters following the word
		this.isSpelledCorrectly = false;
		this.bestPossibleSolutions = null; // initial value to be changed through findSuggestions
	}

	public static boolean isΑNumber(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}

	public static boolean isFirstWord(String input, int count) {
		Word last = DataInput.wordsList.get(count - 2);
		char lchar = last.dividingChars.charAt(last.dividingChars.length());
		if (count == 1) {
			return true;
		} else if (lchar != '.' && lchar != '!'&& lchar != ';') { 
			return true;
		} else {
			return false;
		}
	}

	public void wordProcessing() throws SQLException {
		String input = this.word;
		int count = this.count;
		if (isΑNumber(input)) {
			this.isSpelledCorrectly = true;
		} else if (isFirstWord(input, count)) {
			this.isSpelledCorrectly = (existsInDictionary(input) || existsInDictionary(input.toLowerCase()));
			if (this.isSpelledCorrectly = false) {
				this.findSuggestions();
			}
		} else {
			this.isSpelledCorrectly = existsInDictionary(input);
			if (this.isSpelledCorrectly = false) {
				this.findSuggestions();
			}
		}
	}

	public boolean existsInDictionary(String input) throws SQLException {
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/javadics?useSSL=false";
			String username = "root"; // here you will write the username of the MySQL connection
			String password = "SnowWhite"; // here you will write the password of the MySQL connection
			Connection myConn = DriverManager.getConnection(url, username, password);
			CallableStatement cStmt = myConn.prepareCall("{call existsindictionary(?)}");
			cStmt.setString(1, input);
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

	public void findSuggestions() throws SQLException {
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/javadics?useSSL=false";
			String username = "root"; // here you will write the username of the MySQL connection
			String password = "SnowWhite"; // here you will write the password of the MySQL connection
			Connection myConn = DriverManager.getConnection(url, username, password);
			CallableStatement cStmt = myConn.prepareCall("{call findsuggestions(?)}");
			cStmt.setString(1, this.word);
			cStmt.execute();
			ResultSet rs = cStmt.getResultSet();
			String[] str = new String[3];
			int i = 0;
			while (rs.next()) {
				// bestPossibleSolutions[i] = rs.getString(i + 1);
				str[i] = rs.getString(1);
				i++;
			}
			bestPossibleSolutions = str;
			rs.close();
			cStmt.close();
			myConn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDividingChars() {
		return dividingChars;
	}

	public void setDividingChars(String dividingChars) {
		this.dividingChars = dividingChars;
	}

	public boolean getIsSpelledCorrectly() {
		return isSpelledCorrectly;
	}

	public void setSpelledCorrectly(boolean isSpelledCorrectly) {
		this.isSpelledCorrectly = isSpelledCorrectly;
	}

	public String[] getBestPossibleSolutions() {
		return bestPossibleSolutions;
	}

	public void setBestPossibleSolutions(String[] bestPossibleSolutions) {
		this.bestPossibleSolutions = bestPossibleSolutions;
	}
}
