import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DataInput {
	
	public static String[] inputFromUser() {
		Scanner input = new Scanner(System.in);
		String words = input.nextLine();
		input.close();
		return split(words);
	}
	
	public static String[] inputFromTxt(String path) throws IOException, FileNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(path);
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(fileInputStream));

		String words = "";
		String currentWord = null;
		
		while ((currentWord = bufferReader.readLine()) != null) {
		    words += currentWord;
		}
		bufferReader.close();
		return split(words);
		
	}

	private static String[] split(String words) {
		words = words.toLowerCase();
		return words.split("[^\\p{L}\\p{N}]+");
	}
	
}
