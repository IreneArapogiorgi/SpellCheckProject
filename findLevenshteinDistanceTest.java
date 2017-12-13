package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class findLevenshteinDistanceTest {

	private String word;
	@Test
	public void test() {
		JunitTesting test = new JunitTesting();
		word = "μήκο";
		int output = test.findLevenshteinDistance("μήλο");
		assertEquals(1,output);
	}
	@Test
	public void test2() {
		JunitTesting test = new JunitTesting();
		word = "μηλό";
		int output = test.findLevenshteinDistance("μήλο");
		assertEquals(2,output);
	}
	@Test
	public void test3() {
		JunitTesting test = new JunitTesting();
		word = "μήκο";
		int output = test.findLevenshteinDistance("μηλο");
		assertEquals(1,output);
	}
	@Test
	public void test4() {
		JunitTesting test = new JunitTesting();
		word = "μήκκο";
		int output = test.findLevenshteinDistance("μήλο");
		assertEquals(1,output);
	}
	@Test
	public void test5() {
		JunitTesting test = new JunitTesting();
		word = "μήο";
		int output = test.findLevenshteinDistance("μήλο");
		assertEquals(1,output);
	}
	@Test
	public void test6() {
		JunitTesting test = new JunitTesting();
		word = "μήλο";
		int output = test.findLevenshteinDistance("μήλο");
		assertEquals(1,output);
	}
	

}
