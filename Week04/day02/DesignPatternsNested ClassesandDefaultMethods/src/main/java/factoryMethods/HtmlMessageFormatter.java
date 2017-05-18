package factoryMethods;

class HtmlMessageFormatter implements MessageFormatter {

	public String format(String text) {
		return "<strong>" + text + "</strong>";
	}

}
