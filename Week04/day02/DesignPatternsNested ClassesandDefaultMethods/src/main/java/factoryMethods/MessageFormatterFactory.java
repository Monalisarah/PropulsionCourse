package factoryMethods;

public class MessageFormatterFactory {

	private static final MessageFormatter CONSOLE_FORMATTER = new ConsoleMessageFormatter();
	private static final MessageFormatter HTML_FORMATTER = new HtmlMessageFormatter();
	// private static final MessageFormatter DEFAULT_FORMATTER1 = new
	// DefaultMessageFormatter();
	
	//this one is not private, if you want to make it private you have to hide it in a method and make this private static final
	static final MessageFormatter anonymous = new MessageFormatter() {
		public String format(String text) {
			return text + "anonymous";
		}
	};
	
	// semicolon after constructor means it is an anonymous class

	// static -> only one, always returns the same instance
	public static MessageFormatter createConsoleFormatter() {
		
		
		return CONSOLE_FORMATTER;
	}

	// static -> only one, always returns the same instance
	public static MessageFormatter createHtmlFormatter() {
		return HTML_FORMATTER;
	}
	
	
	
//
//	// static -> only one, always returns the same instance
//	public static MessageFormatter createDefaultFormatter() {
//		return DEFAULT_FORMATTER
//	}


		// private static class DefaultMessageFormatter implements
		// MessageFormatter {
		// public String format(String text) {
		// return text + "!";
		// }

//	}

	//
	// public static MessageFormatter createConsoleFormatter(){
	// return new ConsoleMessageFormatter();
	// }
	//
	// public static MessageFormatter createHtmlFormatter(){
	// return new HtmlMessageFormatter();
	// }
	//
}
