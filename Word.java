package SpellChecker;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
//imports classes to be used in connection with database

/**
 * Word class provides all the useful information about each word of the given text and all the necessary functionalities to process the words.
 * <p>
 * The uses of the class are to: <br>
 * - determine whether a word is the first word of the sentence <br>
 * - determine whether a string consists only of numeric characters <br>
 * - determine whether a word is spelled correctly <br>
 * - find the three most relevant words in the dictionary, to suggest as corrections if the word is incorrect <br>
 * @author Javengers team
 */


public class Word {

	// class variables

	private static int index; // number of word orderly in the sentence

	/**
	 *field to be used in existsInDictionary and findSuggestions in
	 *order to connect to the MySQL database
	 *@see existsInDictionary(String)
	 *@see findSuggestions()
	 */
	protected static Connection myConn;
	
	private int count;

	private String word;

	private boolean isSpelledCorrectly;

	private String[] bestPossibleSolutions = new String[3];

	private String dividingChars;
	
	private static Pattern pattern = Pattern.compile("\\d+");

	/**
	 * Class Constructor
	 * <p> When creating an object, the index variable gets increased by one and its value
	 * is inserted in the count value, thus the (static) index variable shows the number<br>
	 * of objects created and the count shows the ascending number of each object.
	 * @param inputWord - the word (or number) of the object
	 * @param dividingChars - the symbols that follow the word
	 * @throws SQLException
	 */
	public Word(String inputWord, String dividingChars) throws SQLException {
		this.count = ++index;
		this.word = inputWord;
		this.dividingChars = dividingChars;
	}

	/**
	 * Method that checks if a String is a number, so as to not
	 * check if numbers exist in the database.
	 * @param str input String
	 * @return
	 */
	public static boolean isΑNumber(String str) {
		return pattern.matcher(str).matches();
	}
	
	/**
	 * Method that checks if the String of the given word is the first word of the sentence the user wrote.
	 * it takes as input a String with the word the user gave and its count in the List of Words that holds the full text
	 * it is checked both from whether count is equal to 1 
	 * AND from wether the dividingChars of the previous Word object in the list are such that declare the end of the sentence.
	 * in the mentioned cases the method returns true, otherwise it returns false
	 * the usage of this method is needed to determine how the word will be later processed 
	 * @param input input String , count input int
	 * @return boolean
	 */
	
	public static boolean isFirstWord(String input, int count) {
		Word last = DataInput.wordsList.get(count - 1);
		char lchar = last.dividingChars.charAt(last.dividingChars.length());
		if (count == 1) {
			return true;
		} else if (lchar != '.' && lchar != '!'&& lchar != ';') { 
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method that calls the existInDictionary and findSuggestions methods accordingly
	 * <p>If the input is too long and not found in the database, the largest words of the database
	 * are used as suggestions. In case of the String being a number,<br> then it is considered correct
	 * and if it is the first word of a sentence it is checked with both an upper case and an lower case
	 * first letter.<br> If the previous cases are not met, and the word is not found in the database, then
	 * the findSuggestions method is called.
	 * @throws SQLException
	 */
	
	public void wordProcessing() throws SQLException {
		String input = this.word;
		int count = this.count;
		if (input.length() == 0) {
			this.isSpelledCorrectly = true;
		} else if (input.length() > 25 ) {
			 
			if (input.length() <= 27 ) {
				this.isSpelledCorrectly = existsInDictionary(input);
			} else {
				this.isSpelledCorrectly = false;
			}
			if (this.isSpelledCorrectly == false) {
				this.bestPossibleSolutions[0] = "στρογγυλοκουλουριαζόμασταν";
				this.bestPossibleSolutions[1] = "στρογγυλοκουλουριαζόσασταν";
				this.bestPossibleSolutions[2] = "στρογγυλοκουλουριαζόντουσαν";
			}
		} else if (isΑNumber(input)) {
			this.isSpelledCorrectly = true;
		} else if (isFirstWord(input, count)) {
			this.isSpelledCorrectly = (existsInDictionary(input) || existsInDictionary(input.toLowerCase()));
			if (this.isSpelledCorrectly == false) {
				this.findSuggestions();
			}
		} else {
			this.isSpelledCorrectly = existsInDictionary(input);
			if (this.isSpelledCorrectly == false) {
				this.findSuggestions();
			}
		}
	}

	/** 
	 * Method used to check if a word exists in the dictionary of the database.
	 * <p>
	 * Method existsInDictionary receives the input, connects to the MySQL database,
	 * in order to use a MySQL Stored Procedure<br> and search for the word in the database.
	 * If a result is returned from the stored procedure, then the word has been found.
	 * 
	 * @param input - the word being searched
	 * @return boolean result based on whether the word is spelled correctly
	 * @throws SQLException
	 */
	public boolean existsInDictionary(String input) throws SQLException {
		
		CallableStatement cStmt = myConn.prepareCall("{call existsindictionary(?)}");
		cStmt.setString(1, input);
		cStmt.execute();
		if (cStmt.getResultSet().next()) {
			return true;
		} else {
			return false;
		}
		
	}

	public void findSuggestions() throws SQLException {
	
		CallableStatement cStmt = myConn.prepareCall("{call findsuggestions(?)}");
		cStmt.setString(1, this.word);
		cStmt.execute();			
		ResultSet rs = cStmt.getResultSet();
		String[] str = new String[3];
		int i = 0;
		while (rs.next()) {
			str[i] = rs.getString(1);
			i++;
		}
		bestPossibleSolutions = str;
		rs.close();
		cStmt.close();
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
	
	@Override
	public String toString() {
		return word + dividingChars;
	}
}
