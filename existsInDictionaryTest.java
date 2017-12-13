package testing;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class existsInDictionaryTest {

	private String word;
	@Test
	public void test() throws SQLException {
		JunitTesting test = new JunitTesting();
		word = "μήλο";
		test.existsInDictionary();
		boolean value = test.getIsSpelledCorrectly();
		assertEquals(true, value);
		
	}
	@Test
	public void test2() throws SQLException {
		JunitTesting test = new JunitTesting();
		word = "μήκο";
		test.existsInDictionary();
		boolean value = test.getIsSpelledCorrectly();
		assertEquals(false, value);
		
	}
	@Test
	public void test3() throws SQLException {
		JunitTesting test = new JunitTesting();
		word = "1234";
		test.existsInDictionary();
		boolean value = test.getIsSpelledCorrectly();
		assertEquals(true, value);
		
	}

}
