package spellchecker;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
//imports classes to be used in connection with database

public class Word {

	// class variables

	private static int index; // number of word orderly in the sentence

	/**
	 * field to be used in existsInDictionary and findSuggestions in order to
	 * connect to the MySQL database
	 * 
	 * @see existsInDictionary(String)
	 * @see findSuggestions()
	 */

	private int count;

	private String word;

	private boolean isSpelledCorrectly;

	private String[] bestPossibleSolutions = new String[3];

	private String dividingChars;

	private static Pattern pattern = Pattern.compile("\\d+");

	/**
	 * Class Constructor
	 * <p>
	 * When creating an object, the index variable gets increased by one and its
	 * value is inserted in the count value, thus the (static) index variable shows
	 * the number<br>
	 * of objects created and the count shows the ascending number of each object.
	 * 
	 * @param inputWord
	 *            - the word (or number) of the object
	 * @param dividingChars
	 *            - the symbols that follow the word
	 * @throws SQLException
	 */
	public Word(String inputWord, String dividingChars) throws SQLException {
		this.count = ++index;
		this.word = inputWord;
		this.dividingChars = dividingChars;
	}

	/**
	 * Method that checks if a String is a number, so as to not check if numbers
	 * exist in the database.
	 * 
	 * @param str
	 *            input String
	 * @return
	 */
	public boolean isΑNumber() {
		return pattern.matcher(this.getWord()).matches();
	}

	public boolean isFirstWord() {
		int count = this.getCount();
		if (count <= 1) {
			return true;
		} else {
			if (SpellCheckerUI.wordsList.get(count - 1).getDividingChars().matches("[;!.]")) {
				return true;
			} else {
				return false;
			}
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Method that calls the existInDictionary and findSuggestions methods
	 * accordingly
	 * <p>
	 * If the input is too long and not found in the database, the largest words of
	 * the database are used as suggestions. In case of the String being a
	 * number,<br>
	 * then it is considered correct and if it is the first word of a sentence it is
	 * checked with both an upper case and an lower case first letter.<br>
	 * If the previous cases are not met, and the word is not found in the database,
	 * then the findSuggestions method is called.
	 * 
	 * @throws SQLException
	 */

	public void wordProcessing() throws SQLException {
		String input = this.word;
		if (input.length() == 0) {
			this.isSpelledCorrectly = true;
		} else if (input.length() > 25) {

			if (input.length() <= 27) {
				this.isSpelledCorrectly = existsInDictionary(input);
			} else {
				this.isSpelledCorrectly = false;
			}
			if (this.isSpelledCorrectly == false) {
				this.bestPossibleSolutions[0] = "στρογγυλοκουλουριαζόμασταν";
				this.bestPossibleSolutions[1] = "στρογγυλοκουλουριαζόσασταν";
				this.bestPossibleSolutions[2] = "στρογγυλοκουλουριαζόντουσαν";
			}
		} else if (this.isΑNumber()) {
			this.isSpelledCorrectly = true;
		} else if (this.isFirstWord()) {
			this.isSpelledCorrectly = (existsInDictionary(input) || existsInDictionary(input.toLowerCase()));
			if (this.isSpelledCorrectly && input.equals(input.toLowerCase())) {
				this.isSpelledCorrectly = false;
				if (input.length() == 1) {
					this.bestPossibleSolutions[0] = input.toUpperCase();
					this.bestPossibleSolutions[1] = input.toUpperCase();
					this.bestPossibleSolutions[2] = input.toUpperCase();

				} else {
					this.bestPossibleSolutions[0] = input.substring(0, 1).toUpperCase().concat(input.substring(1));
					this.bestPossibleSolutions[1] = input.substring(0, 1).toUpperCase().concat(input.substring(1));
					this.bestPossibleSolutions[2] = input.substring(0, 1).toUpperCase().concat(input.substring(1));
				}
			}
			if (this.isSpelledCorrectly == false) {
				this.findSuggestions();
				if (input.length() == 1) {
					this.bestPossibleSolutions[0] = this.bestPossibleSolutions[0].toUpperCase();
					this.bestPossibleSolutions[1] = this.bestPossibleSolutions[1].toUpperCase();
					this.bestPossibleSolutions[2] = this.bestPossibleSolutions[2].toUpperCase();

				} else {
					this.bestPossibleSolutions[0] = this.bestPossibleSolutions[0].substring(0, 1).toUpperCase()
							.concat(this.bestPossibleSolutions[0].substring(1));
					this.bestPossibleSolutions[1] = this.bestPossibleSolutions[1].substring(0, 1).toUpperCase()
							.concat(this.bestPossibleSolutions[1].substring(1));
					this.bestPossibleSolutions[2] = this.bestPossibleSolutions[2].substring(0, 1).toUpperCase()
							.concat(this.bestPossibleSolutions[2].substring(1));
				}
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
	 * in order to use a MySQL Stored Procedure<br>
	 * and search for the word in the database. If a result is returned from the
	 * stored procedure, then the word has been found.
	 * 
	 * @param input
	 *            - the word being searched
	 * @return boolean result based on whether the word is spelled correctly
	 * @throws SQLException
	 */
	public boolean existsInDictionary(String input) throws SQLException {
		try {
			CallableStatement cStmt = SpellCheckerUI.myConn.prepareCall("{call existsindictionary(?)}");
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
			CallableStatement cStmt = SpellCheckerUI.myConn.prepareCall("{call findsuggestions(?)}");
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

	@Override
	public String toString() {
		return word + dividingChars;
	}
}
