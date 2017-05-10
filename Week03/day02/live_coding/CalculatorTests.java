
package util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.Calculator;

public class CalculatorTests {

	@Test
	public void add() {
		Calculator calculator = new Calculator();
		assertEquals(10, calculator.add(7.0, 3.00001), 0.00001);
	}

	@Test
	public void subtract() {
		Calculator calculator = new Calculator();
		assertEquals(4, calculator.subtract(7, 3), 0);
	}

}
