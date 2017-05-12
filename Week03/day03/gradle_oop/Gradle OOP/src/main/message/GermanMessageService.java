package main.message;

public class GermanMessageService implements MessageService { // this is an implementation of the interface 

	@Override
	public String generateMessage(String name) {
		return ("Hallo "+ name);
	}  
}
