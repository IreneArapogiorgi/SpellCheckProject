import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class DataInput {
	
	public static Word[] readInputFromTxt(String path, String encodingType) throws IOException, FileNotFoundException, UnsupportedEncodingException {
		FileInputStream fileInputStream = new FileInputStream(path);
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(fileInputStream, encodingType));
		final String newLine = System.lineSeparator();

		String words = "";
		String currentWord = null;
		
		bufferReader.mark(1); //BOM handling
		if (bufferReader.read() != 0xFEFF){
			bufferReader.reset();
		}
		while ((currentWord = bufferReader.readLine()) != null) {
			words += currentWord + newLine;
		}
		
		words = words.substring(0,words.length()-2); //discarding the last newline
		bufferReader.close();
		return splitStringToWords(words);
		
	}

	private static Word[] splitStringToWords(String words) {
		final String notWordOrNumber = "([^\\p{L}\\p{N}]+)";
		String[] wordsArray = words.split(
				"(?=(?!^)"+notWordOrNumber+")(?<!"+notWordOrNumber+")|(?!"+notWordOrNumber+")(?<="+notWordOrNumber+")");
		Word[] wordsType = new Word[wordsArray.length/2];
		
		for (int i = 0; i < wordsArray.length - 1; i += 2){
			 wordsType[i/2] = new Word(wordsArray[i], wordsArray[i+1]);
		}
		return wordsType;
	}
	
}
