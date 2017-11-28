
public class Word {


	private String word ;
	
	private String dividingChars;
	
	public Word(String inputWord , String dividingChars){	//class constructor

		this.word = inputWord;			//what the user wrote
		this.dividingChars = dividingChars;	//non-letter characters following the word
	}
	
	public String toString(){
		return word + "||" + dividingChars;
	}

}
