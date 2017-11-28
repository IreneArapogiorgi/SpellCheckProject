import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		double time = System.currentTimeMillis();
		
		Word[] words = DataInput.readInputFromTxt("C:\\Users\\nick\\Desktop\\text.txt", "UTF-8");
		
		for (Word word: words){
		    System.out.println("[" + word + "]");
		}
		System.out.println(words.length);
		double time2 = System.currentTimeMillis();
		System.out.println("Program took " + (double)(time2-time)/1000 + " seconds to execute.");
	}
}
