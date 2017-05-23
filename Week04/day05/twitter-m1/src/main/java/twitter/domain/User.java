package twitter.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class User {
	
	private final String id = UUID.randomUUID().toString();
	private final LocalDateTime dateCreated = LocalDateTime.now();
	private String fullName;
	private String emailAdress;
	private String userName;
	private String password;
	private List<Tweet> tweets = new ArrayList<>();
	
	
	public User(String fullName, String emailAdress, String userName, String password) {
		this.fullName = fullName;
		this.emailAdress = emailAdress;
		this.userName = userName;
		this.password = password;
	}
	
	public void addTweet(Tweet tweet){
		tweets.add(tweet);
	
		}
	
	
	
	

	
}
