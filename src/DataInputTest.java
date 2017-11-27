import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Word[] words = DataInput.readInputFromTxt("C:\\Users\\nick\\Desktop\\text.txt", "UTF-8");
		for (Word word: words)
		System.out.println("[" + word + "]");
		System.out.println(words.length);
	}
}
