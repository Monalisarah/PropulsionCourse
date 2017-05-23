package twitter.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import twitter.domain.Tweet;
import twitter.domain.User;

public class TweetTest {

	@Test
	public void test() {
		User user01 = new User("KarstenNordhausen", "karsten@me.com","TwitterKarsten", "mySecurePW");
		Tweet tweet01 = new Tweet("KarstensFirstTweet", user01);
		
		assertEquals(1, user01.getTweets().size());
		assertEquals("KarstensFirstTweet", user01.getTweets().get(0).getText());
		
	}

}
