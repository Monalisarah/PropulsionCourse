package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.abstractMessage.EnglishMessageService;
import main.abstractMessage.GermanMessageService;
import main.abstractMessage.MessageService;



public class MessageServiceTest {
	
	public MessageService messageServiceTest;

	@Test
	public void englishMessageService() {
		messageServiceTest = new EnglishMessageService();
		assertEquals("Hello Simona :)", messageServiceTest.generateMessage("Simona"));
		
	}
	
	public void germanMessageService() {
		messageServiceTest = new GermanMessageService();
		assertEquals("Hallo Simona :)", messageServiceTest.generateMessage("Simona"));
		
	}


}
