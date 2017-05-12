package main.message;

public class GreetingClient {
 
	// fields or properties
	private final MessageService messageService;  // MessageService is the type and messageService is the name of the property or the field
	
	// constructor 
	public GreetingClient(MessageService messageService){
		this.messageService = messageService;
	}
	
	//method
	public String greetUser(String name) {
		String msg = this.messageService.generateMessage(name);
		return msg.toUpperCase();
	}
	
}
