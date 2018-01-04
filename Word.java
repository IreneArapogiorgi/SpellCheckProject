package SpellChecker;

import java.util.List;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//imports classes to be used in connection with database

public class Word {

	// class variables

	private String word;

	private boolean isSpelledCorrectly;

	private String bestPossibleSolution;

	private String dividingChars;

	public Word(String inputWord, String dividingChars) { // class constructor

		this.word = inputWord; // what the user wrote
		this.isSpelledCorrectly = false; // initial value to be changed through existsInDictionary
		this.bestPossibleSolution = null; // initial value to be changed through findSuggestions
		this.dividingChars = dividingChars; // non-letter characters following the word
	}

	public static boolean existsInDictionary(String word, int length) throws SQLException {
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/javadics?useSSL=false";
			Connection myConn = DriverManager.getConnection(url, "AngelG", "SnowWhite");
			CallableStatement cStmt = myConn.prepareCall("{call existsindictionary(?)}");
			cStmt.setString(1, word);
			cStmt.execute();
			if (cStmt.getResultSet().next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(1);
			return false;
		}
	}

	public int findLevenshteinDistance(String wordOfDictionary) {
		// could be a stored procedure?
		// to be called in the queries of the next method
		// are the objects in the existsInDictionary visible to use?

		int[][] table = new int[this.word.length() + 1][wordOfDictionary.length() + 1]; // two dimension matrix table
		int cost = 0;

		// variables that will hold the Levenshtein math types
		int delete;
		int insert;
		int substitute;

		// initializing first line
		for (int i = 0; i <= this.word.length(); i++) {
			table[i][0] = i;
		}
		// initializing first column
		for (int j = 0; j <= wordOfDictionary.length(); j++) {
			table[0][j] = j;
		}

		// comparing words
		for (int i = 1; i <= this.word.length(); i++) {
			for (int j = 1; j <= wordOfDictionary.length(); j++) {
				if (this.word.charAt(i - 1) == wordOfDictionary.charAt(j - 1)) {
					cost = 0; // if letters are the same, cost is zero
				} else {
					cost = 1; // if letters are not the same, cost is one
				}

				// Levenshtein math types
				delete = table[i - 1][j] + 1; // the element moves 1 line upward
				insert = table[i][j - 1] + 1; // the element moves 1 column left
				substitute = table[i - 1][j - 1] + cost; // the element moves BOTH 1 column left AND 1 line upward

				table[i][j] = Math.min(delete, Math.min(insert, substitute)); // minimum value is assigned

			}
		}

		return table[this.word.length()][wordOfDictionary.length()];

	}


		
	//findSuggestions with distance
	//this method needs a table with words and length of the words
		//imports


	public static List<String> findSuggestions(String word, int wordLength) throws Exception{
		Connection con = null;
		DBConnection dbc = new DBConnection();

		String sql = "SELECT word FROM words WHERE length > 1 AND length < 4;";
		String dbWord = null;
		List <String> listOfWords = new ArrayList<String>();

		try {
			dbc.open();
			con = dbc.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while ( rs.next()) {
				dbWord = rs.getString("word");
				if(dbWord != null) {
					if (Distance3.levinDistance(word, dbWord) <= 3) {
						listOfWords.add(dbWord);
					}
				}

			}

			rs.close();
			stmt.close();
			dbc.close();

			return listOfWords;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
					dbc.close();
			} catch (Exception e) {
				//do nothing
			}
		}

	}
	

	// get methods

	public String getBestPossibleSolution() { // provides access to private value

		return this.bestPossibleSolution;

	}

	public boolean getIsSpelledCorrectly() { // provides access to private value

		return this.isSpelledCorrectly;

	}

	public String getWord() { // provides access to private value

		return this.word;

	}

	private String getDividingChars() { // provides access to private value

		return this.dividingChars;

	}
}