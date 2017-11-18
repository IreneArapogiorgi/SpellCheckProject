
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
		Statement stmt = null;

		try{
			// establishing connection with database
			con = DriverManager.getConnection("jdbc:myDriver:myDatabase","username","password"); 
			
			//creating a statement object to query the database
			stmt = con.createStatement();
			
			//creating a result set object to hold the query results
			ResultSet rs = stmt.executeQuery("SELECT * FROM Dictionary WHERE Dictionary.Word = this.word");
			// we have to find a method to use instead of executeQuery, so that we can pass the parameter of the given word
			// otherwise we could use this "bad programming practice" :
			// select ... where t=' " +word+"'")
			
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

	public int  findLevenshteinDistance() {
		//could be a stored procedure?
		//to be called in the queries of the next method
		//are the objects in the existsInDictionary 
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
