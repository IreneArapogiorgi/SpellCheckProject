import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//System.out.println("give");
		//String[] words = DataInput.inputFromUser();
		//for (String x: words )
		//System.out.println(x);
		String[] words = DataInput.inputFromTxt("C:\\Users\\nick\\Desktop\\text.txt");
		for (String word: words)
		System.out.println(word);
	}
}
