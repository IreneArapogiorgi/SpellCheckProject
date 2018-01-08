package org.test.junit.core;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * DataInputTest_splitStringToWords class is used to verify the correctness of
 * splitStringToWords method from DataInput class.
 * 
 * @throws SQLException
 * @throws Exception
 *
 * @author Javengers team
 *
 */

public class DataInputTest_splitStringToWords {

	@Before
	public void setUp() throws Exception {
		System.out.println("setting up...");
	}

	/**
	 * testSplitStringToWords method is used to verify the correctness of
	 * splitStringToWords method from Word class.
	 * <p>
	 * testSplitStringToWords initializes a string (x), creates two Word objects
	 * and sets as a parameter one of the splitted words for each object It
	 * inserts splitted the words into an arraylist.
	 *
	 * assert statements assertTrue checks that the boolean condition is true.
	 * a) First element in the list must be equal to the first parameter of the
	 * object word1 b) Second element in the list must be equal to the second
	 * parameter of the object word2
	 */
	@Test
	public void testSplitStringToWords() throws SQLException {
		String x = "Ο καιρώς.";
		Word o = new Word("Ο", " ");
		Word kairos = new Word("καιρώς", ".");
		List<Word> list = new ArrayList<Word>();
		list = DataInput.splitStringToWords(x);

		assertTrue((o.getWord().equals(list.get(0).getWord()))
				&& (o.getDividingChars().equals(list.get(0).getDividingChars()))
				&& (kairos.getWord().equals(list.get(1).getWord()))
				&& (kairos.getDividingChars().equals(list.get(1).getDividingChars())));
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("ending...");
	}

}
