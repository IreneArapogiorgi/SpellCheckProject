
public class Words {

	public Words(String inputWord){

		this.word = inputWord;
		this.isSpelledCorrect = false; 		//initializing values
		this.bestPossibleSolution = null; 	//to be changed

	}

	private String word ;

	private boolean isSpelledCorrectly ;

	private String bestPossibleCorrection ;

	public boolean existsInDictionary() {
		// method that determines the value of isSpelledCorrectly
		//could return void though - depends on structure
	}

	public String findSuggestions() {
		// method to be called when the boolean remains false
		//should determine the value of bestPossibleSolution
		//could return void - depends on structure
	}

	public String getBestPossibleSolution() {

		return this.bestPossibleSolution;

	}

	public boolean getIsSpelledCorrectly() {

		return this.isSpelledCorrectly;

	}
}
