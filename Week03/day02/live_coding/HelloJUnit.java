
package demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class HelloJUnit {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Rule
	public Timeout timeout = Timeout.millis(20);

	@Test
	public void firstTest() {

		boolean bool = true;
		assertTrue(bool);
		// assertFalse("2 * 2 == 10", 2 * 2 == 10);
		assertEquals(2 * 3, 6);
		assertNotEquals(2, 4);
		assertNull(null);
		String name = "foo";
		assertNotNull(name);
		//throw new RuntimeException();
		assertEquals("foo", name);

	}

	@Test
	public void timeouts() throws InterruptedException {
		Thread.sleep(10);
	}

	@Test
	public void exceptions() {
		/* some method in our production code */
		exception.expect(RuntimeException.class);
		exception.expectMessage("Boom!");
		blowUp();
	}

	private void blowUp() {
		throw new RuntimeException("Boom!");
	}

}
