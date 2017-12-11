/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package my.spellchecker;

/**
 *
 * @author earapogiorgi
 */
public class Word {
    
	private String word ;
	
	private final String dividingChars;
	
	public Word(String inputWord , String dividingChars){	//class constructor

		this.word = inputWord;			//what the user wrote
		this.dividingChars = dividingChars;	//non-letter characters following the word
	}
	
	@Override
        public String toString(){
		return word + "||" + dividingChars;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
