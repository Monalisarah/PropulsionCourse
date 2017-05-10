package util;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTests {

	@Test
	public void testHappyPath() {
		assertEquals(13, Fibonacci.fibonacci(7),0);
		assertEquals(0, Fibonacci.fibonacci(0),0);	
	}
	
}
