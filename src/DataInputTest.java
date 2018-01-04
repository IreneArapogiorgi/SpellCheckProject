import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class DataInputTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, NullPointerException {
		double time = System.currentTimeMillis();
		System.out.println(" Enter 1 for input from txt\n Enter 2 for input from URL");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		in.close();
		List<Word> words;
		if (choice == 1) {
			words = DataInput.readInputFromTxt("C:\\Users\\nick\\Desktop\\text.txt", "UTF-8");
		} else if (choice == 2) {
			words = DataInput.readInputFromHtml("https://www.aueb.gr/");
		} else {
			words = null;
		}

		try {
			for (Word word : words) {
				System.out.println(word);
			}
			System.out.println(" size = " + words.size());
			double time2 = System.currentTimeMillis();
			double execTime = (time2 - time) / 1000;
			System.out.println("Program took " + execTime + " seconds to execute, " + (1000 * execTime / words.size())
					+ " milliseconds per word");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
}
