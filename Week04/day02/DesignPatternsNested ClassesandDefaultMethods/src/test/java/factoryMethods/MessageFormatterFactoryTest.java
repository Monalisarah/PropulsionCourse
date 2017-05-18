package factoryMethods;

import static org.junit.Assert.*;

import org.junit.Test;

import factoryMethods.MessageFormatterFactory;
import junit.framework.Assert;

public class MessageFormatterFactoryTest {

	@Test
	public void consoleTest() {
		MessageFormatter consoleMessageFormatter = MessageFormatterFactory.createConsoleFormatter();
		assertEquals("hallo!", consoleMessageFormatter.format("hallo"));
	}
	
	@Test
	public void htmlTest() {
		MessageFormatter htmlMessageFormatter = MessageFormatterFactory.createHtmlFormatter();
		assertEquals("<strong>hallo</strong>", htmlMessageFormatter.format("hallo"));
	}
	
	@Test
	public void sameObjectTest() {
		MessageFormatter consoleMessageFormatter = MessageFormatterFactory.createConsoleFormatter();
		MessageFormatter consoleMessageFormatter1 = MessageFormatterFactory.createConsoleFormatter();
		assertSame(consoleMessageFormatter, consoleMessageFormatter1);
		
	}
	
	@Test
	public void anonymousObjectTest() {
		MessageFormatter anonymousFormatter = MessageFormatterFactory.anonymous;
		assertEquals("halloanonymous", anonymousFormatter.format("hallo"));
		
	}
	

	
	
	

}
