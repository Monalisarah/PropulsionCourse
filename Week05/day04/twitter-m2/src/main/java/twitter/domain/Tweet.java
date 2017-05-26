package twitter.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude ="id")
public class Tweet {
	private int id;
	private String text;
	private String author;
	
	public Tweet(String text, String author) {
		this.text = text;
		this.author = author;
	}

	public Tweet(int id, String text, String author) {
		this.id = id;
		this.text = text;
		this.author = author;
	}
	
	
	
	
}
