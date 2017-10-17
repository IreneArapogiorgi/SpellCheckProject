import java.util.Scanner;
public class DataInput {
	
	public static String[] inputFromUser() {
		Scanner input = new Scanner(System.in);
		String words = input.nextLine();
		words = words.toLowerCase();
		input.close();
		return words.split("[^\\p{L}\\p{N}]+");
	}
	
	public static String[] inputFromTxt() {
		return null;
		
	}
	
}
