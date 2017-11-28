
import java.sql.*;	//imports classes to be used in connection with database

public class Word {

	// class variables
	
	private String word ;

	private boolean isSpelledCorrectly ;

	private String bestPossibleCorrection ;
	
	private String dividingChars;
	
	public Words(String inputWord , String dividingChars){	//class constructor

		this.word = inputWord;			//what the user wrote
		this.isSpelledCorrectly = false; 	//initial value to be changed through existsInDictionary
		this.bestPossibleSolution = null; 	//initial value to be changed through findSuggestions
		this.dividingChars = dividingChars;	//non-letter characters following the word
	}

	public void existsInDictionary() throws SQLException {
		// method that determines the value of isSpelledCorrectly
		Connection con = null;
		PreparedStatement stmt = null ;
		
		try{
			// establishing connection with database
			con = DriverManager.getConnection("jdbc:myDriver:myDatabase","username","password"); 
			
			//creating a statement object to query the database
			stmt = con.prepareStatement("SELECT DISTINCT* FROM Dictionary WHERE Dictionary.Word = ? " ) ;
			stmt.setString( 1 , this.word);
			
			//creating a result set object to hold the query results
			ResultSet rs = stmt.executeQuery();
						
			if(rs.getString("Dictionary.Word") == this.word){	//getString method helps us read what the query return and compare it
				this.isSpelledCorrectly = true;
			} else {
				this.isSpelledCorrectly = false;
				
				//if the given word is false the following method is called to query again the dictionary in search of corrections
				this.findSuggestions();
			}
		} finally {
			if (stmt != null) stmt.close();
		}
	}

	public int  findLevenshteinDistance(String wordOfDictionary) {
		//could be a stored procedure?
		//to be called in the queries of the next method
		//are the objects in the existsInDictionary visible to use?
		
		int[][] table = new int[this.word.length() + 1][wordOfDictionary.length() + 1]; //two dimension matrix table
		int cost = 0;

		//variables that will hold the Levenshtein math types
		int delete;
		int insert;
		int substitute;

		//initializing first line
		for (int i = 0; i <= this.word.length(); i++) {
			table[i][0] = i;
		}
		//initializing first column
		for (int j = 0; j <= wordOfDictionary.length(); j++) {
			table[0][j] = j;
		}

		//comparing words
		for (int i = 1; i <= this.word.length(); i++) {
			for (int j = 1; j <= wordOfDictionary.length(); j++) {
				if (this.word.charAt(i - 1) == wordOfDictionary.charAt(j - 1)) {
					cost = 0; //if letters are the same, cost is zero
				} else {
					cost = 1; //if letters are not the same, cost is one
				}

			//Levenshtein math types
			delete = table[i - 1][j] + 1;			 //the element moves 1 line upward
			insert = table[i][j - 1] + 1; 			 //the element moves 1 column left
			substitute = table[i-1][j-1] + cost;		 //the element moves BOTH 1 column left AND 1 line upward

			table[i][j] = Math.min(delete, Math.min(insert, substitute)); //minimum value is assigned

			}
		}

		return table[this.word.length()][wordOfDictionary.length()];
		
	}
	
	public String findSuggestions() {
		// method to be called when the boolean remains false
		//should determine the value of bestPossibleSolution
		//could return void - depends on structure
		//we could use both distance and soundex - and crossexamine results to find the best possible solution
	}
	
	// get methods
	
	public String getBestPossibleSolution() {	//provides access to private value

		return this.bestPossibleSolution;

	}

	public boolean getIsSpelledCorrectly() {	//provides access to private value

		return this.isSpelledCorrectly;

	}

	public String getWord() {			//provides access to private value

		return this.word;

	}

	private String getDividingChars() {		//provides access to private value
	
		return this.dividingChars;

	}
}
