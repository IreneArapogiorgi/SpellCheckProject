/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package my.spellchecker;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author earapogiorgi
 */
public class DataInput {

    public static String[] inputFromUser(String words) {

        words = words.toLowerCase();
	return words.split("[^\\p{L}\\p{N}]+");
    }

    public static Word[] readFileInput(File file)
                        throws IOException, FileNotFoundException, UnsupportedEncodingException {
        FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
	BufferedReader bufferReader = new BufferedReader(new InputStreamReader(fileInputStream));
	final String newLine = System.lineSeparator();

	StringBuilder words = new StringBuilder();
	String currentWord = null;

	bufferReader.mark(1); //BOM handling
	if (bufferReader.read() != 0xFEFF){
            bufferReader.reset();
	}
	while ((currentWord = bufferReader.readLine()) != null) {
            words.append(currentWord + newLine);
	}

	words.setLength(words.length() - 2); //discarding the last newline
	bufferReader.close();
	return splitStringToWords(words.toString());
    }

    public static Word[] readInputFromTxt(String path, String encodingType)
			throws IOException, FileNotFoundException, UnsupportedEncodingException {
		FileInputStream fileInputStream = new FileInputStream(path);
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(fileInputStream, encodingType));
		final String newLine = System.lineSeparator();

		StringBuilder words = new StringBuilder();
		String currentWord = null;

		bufferReader.mark(1); //BOM handling
		if (bufferReader.read() != 0xFEFF){
			bufferReader.reset();
		}
		while ((currentWord = bufferReader.readLine()) != null) {
			words.append(currentWord + newLine);
		}

		words.setLength(words.length() - 2); //discarding the last newline
		bufferReader.close();
		return splitStringToWords(words.toString());

	}

	private static Word[] splitStringToWords(String words) {
		final String notWordOrNumber = "([^\\p{L}\\p{N}]+)";
		Word[] wordsType;
		int index = 0;

		String[] wordsArray = words.split("(?=(?!^)" + notWordOrNumber + ")(?<!" + notWordOrNumber + ")|"
				+ "(?!" + notWordOrNumber + ")(?<=" + notWordOrNumber + ")");

		int lastWord = wordsArray.length - 1;
		if (wordsArray[lastWord].matches(notWordOrNumber)) {
			if (wordsArray[0].matches(notWordOrNumber)) { // if input starts with a symbol wordsType array should be longer
				wordsType = new Word[wordsArray.length / 2 + 1];
			} else {
				wordsType = new Word[wordsArray.length / 2];
			}
		} else { // if input text ends with a letter
			wordsType = new Word[wordsArray.length / 2 + 1];
			wordsType[wordsType.length - 1] = new Word(wordsArray[lastWord], "");
			lastWord--;
		}
		if (wordsArray[0].matches(notWordOrNumber)) { // if input starts with a symbol
			wordsType[0] = new Word("", wordsArray[0]);
			for (index++; index < lastWord; index += 2){
				 wordsType[index / 2 + 1] = new Word(wordsArray[index], wordsArray[index + 1]);
			}
		} else {
			for (; index < lastWord; index += 2){
				wordsType[index / 2] = new Word(wordsArray[index], wordsArray[index + 1]);
			}
		}
		return wordsType;
	}
}

}
