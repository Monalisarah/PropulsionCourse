package main.abstractMessage;

public abstract class AbstractMessageService implements MessageService {

	@Override
	public String generateMessage(String name) {
		return helloText()+" "+ name + " :)";
	}

	abstract String helloText();
}
