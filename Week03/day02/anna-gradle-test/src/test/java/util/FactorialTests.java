package util;
import static org.junit.Assert.*; // Assert is a external Library

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FactorialTests {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testHappyPath() {
		assertEquals(24, Factorial.factorial(4), 0); // expected, actual, delta, always hardcoded stuff
		assertEquals(1, Factorial.factorial(0), 0);
		assertEquals(120, Factorial.factorial(5), 0);
		assertEquals(720, Factorial.factorial(6), 0);
		
	}

	@Test
	public void testEdges() {
		exception.expect(IllegalArgumentException.class);
		Factorial.factorial(-1);
		
	}
}


