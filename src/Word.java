
public class Word {

	private String word;

	private String dividingChars;

	public Word(String inputWord, String dividingChars) { // class constructor

		this.word = inputWord;
		this.dividingChars = dividingChars;
	}

	@Override
	public String toString() {
		return word + dividingChars;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
