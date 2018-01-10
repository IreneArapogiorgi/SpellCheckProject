package junit.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

	/*
	 * WordTest_isANumber class tests the correctness of isÁNumber method from Word class
	 */

public class WordTest_isANumber {

	// setUp method is executed at the start of every test of junit and prints
	// "setting up..."

	@Before
	public void setUp() throws Exception {
		System.out.println("settinng up...");
	}

	/*
	 * testIsANumber method is used to check if a string is a number.
	 *
	 * assertEguals method checks if the boolean variable (b) is actually true.
	 *
	 */

	@Test
	public void testIsANumber() throws SQLException {
		String x = "23";
		boolean b = Word.isÁNumber(x);
		assertEquals(true, b);

	}

	/*
	 * testIsÁNumber1 method is used to check if a string is a number combined
	 * with letters.
	 *
	 * assertEguals method checks if the boolean variable (b) is actually false.
	 *
	 */

	@Test
	public void testIsANumber1() throws SQLException {
		String x = "2σ34δ";
		boolean b = Word.isÁNumber(x);
		assertEquals(false, b);

	}

	// tearDown method is executed at the end of every test of junit test and
	// prints "end of test"

	@After
	public void tearDown() throws Exception {
		System.out.println("end of test");
	}
}
