package twitter.service;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import twitter.domain.Tweet;
import twitter.domain.User;

public class TweetServiceTest {

	@Test
	public void saveTweet() {
		User user01 = new User("KarstenNordhausen", "karsten@me.com","TwitterKarsten", "mySecurePW");
		Tweet tweet01 = new Tweet("KarstensFirstTweet", user01);
		User user02 = new User("Hans", "hans@me.com","TwitterHans", "hansSecurePW");
		Tweet tweet02 = new Tweet("Hans'sFirstTweet", user02);
		TweetService myTweetService = new TweetService();
		
		assertThat(myTweetService.findAllTweets()).hasSize(0);
		myTweetService.saveTweet(tweet01);
		assertThat(myTweetService.findAllTweets()).hasSize(1);
		myTweetService.saveTweet(tweet02);
		assertThat(myTweetService.findTweet(tweet02.getId())).isEqualTo(tweet02);
		assertThat(myTweetService.findAllTweetsByUsername("TwitterHans")).contains(tweet02);
		assertThat(myTweetService.findAllTweetsByUserId(tweet01.getAuthor().getId())).contains(tweet01);
		myTweetService.deleteTweet(tweet02.getId());
		assertThat(myTweetService.findAllTweets()).hasSize(1);
		
		
		

	}

}
	