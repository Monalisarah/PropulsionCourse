package twitter.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class Tweet {
	
	private final String id = UUID.randomUUID().toString();
	private final LocalDateTime dateCreated = LocalDateTime.now();
	private String text;
	private User author;
	private Tweet replyTo;
	private Tweet reTweet;
	
	public Tweet(String text, User author) {
		this.text = text;
		this.author = author;
		this.author.addTweet(this);
	}
}
