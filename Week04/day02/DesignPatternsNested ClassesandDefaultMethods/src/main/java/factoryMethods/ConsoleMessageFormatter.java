package factoryMethods;

class ConsoleMessageFormatter implements MessageFormatter {
	
	
//	// to make the method more private 
//	public static final MessageFormatter INSTANCE = new ConsoleMessageFormatter();
//	
//	//private constructor 
//	private ConsoleMessageFormatter(){
//		
//	}

	public String format(String text) {
		return text + "!";
	}

}
