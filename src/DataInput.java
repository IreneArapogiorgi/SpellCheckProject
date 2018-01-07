import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Whitelist;

/**
 * Data Input class consists of static methods and is used to:<br>
 * a) read text from a site<br>
 * b) read text from a text file<br>
 * c) split text from plain text to a List of Word objects
 * 
 * @author Javengers team
 * @see Word
 */

public class DataInput {

	/**
	 * Method used to create Word List from the text found in the specified URL
	 * <p>
	 * The method uses Jsoup to connect to a site (using "Mozilla" user agent),
	 * create a Document with the HTML content and clean the Document with
	 * Cleaner and the Whitelist class from the Jsoup library.<br>
	 * The method initially gets the text from the main body of the document. If
	 * the main body is empty of text, the method gets text from the whole
	 * Document.<br>
	 * Lastly, the method uses the splitStringToWords method in order to split
	 * the String with the words to a List of Word objects.
	 * <p>
	 * Note: The string that is split has one single line. Pretty print is kept
	 * enabled, no new lines are added on "br" and "p" tags so as to minimize
	 * the length of the String (without multiple newline characters),<br>
	 * due to the bad "transformation" of HTML to plain text.
	 * 
	 * @param url
	 *            - URL of the site that will be used as input
	 * @return List of Word objects
	 * @throws IOException
	 * @see #splitStringToWords(String)
	 */
	static List<Word> wordsList = new LinkedList<Word>();
	
	public static List<Word> readInputFromHtml(String url) throws IOException {
		Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
		doc = new Cleaner(Whitelist.basic()).clean(doc);
		String text = doc.body().text();

		if (text.length() == 0) {
			text = doc.text();
		}
		return splitStringToWords(text);
	}

	/**
	 * Method used to input text from a file
	 * <p>
	 * readInputFromTxt removes the BOM (if it is found in the text) and then
	 * proceeds to read text using the readLine method from BufferedReader (for
	 * faster execution).<br>
	 * It removes the two redundant last new lines and calls the
	 * splitStringToWords method to split the text to a List of Word objects.
	 * 
	 * @param path
	 *            - location of the file
	 * @param encodingType
	 *            - encoding of the file
	 * @return List of Word objects
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 * @see #splitStringToWords(String)
	 */
	public static List<Word> readInputFromTxt(String path, String encodingType)
			throws IOException, FileNotFoundException, UnsupportedEncodingException {
		FileInputStream fileInputStream = new FileInputStream(path);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, encodingType));
		final String newLine = System.lineSeparator();

		StringBuilder words = new StringBuilder();
		String currentWord = null;

		bufferedReader.mark(1); // BOM handling
		if (bufferedReader.read() != 0xFEFF) {
			bufferedReader.reset();
		}
		while ((currentWord = bufferedReader.readLine()) != null) {
			words.append(currentWord + newLine);
		}

		words.setLength(words.length() - 2); // discarding the two last newlines
		bufferedReader.close();
		return splitStringToWords(words.toString());
	}

	/**
	 * Method is used to make a List of Word objects from a String
	 * <p>
	 * splitStringToWords method splits the text, inserting the word (every word
	 * that includes characters defined as letters from Unicode, or numbers)<br>
	 * in an array and then proceeding to insert the symbols that follow it in
	 * the next index of the array. It creates a List of Word objects,<br>
	 * while handling the cases when the text starts with a symbol or ends with
	 * a letter (or number).
	 * 
	 * @param text
	 *            - text to be processed
	 * @return List of Word objects
	 */

	public static List<Word> splitStringToWords(String text) {
		final String notWordOrNumber = "([^\\p{L}\\p{N}]+)";
		String[] splittedText = text.split("(?=(?!^)" + notWordOrNumber + ")(?<!" + notWordOrNumber + ")|" + "(?!"
				+ notWordOrNumber + ")(?<=" + notWordOrNumber + ")");

		
		int currentWord = 0;

		if (splittedText[0].matches(notWordOrNumber)) {
			wordsList.add(new Word("", splittedText[0]));
			currentWord++;
		}

		for (; currentWord < splittedText.length - 1; currentWord += 2) {
			wordsList.add(new Word(splittedText[currentWord], splittedText[currentWord + 1]));
		}

		if (!(splittedText[splittedText.length - 1].matches(notWordOrNumber))) {
			wordsList.add(new Word(splittedText[splittedText.length - 1], ""));
		}
		return wordsList;
	}

}
