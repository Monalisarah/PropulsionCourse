package TweetService;

import static org.junit.Assert.*;
import org.junit.Test;

public class TweetServiceTest {

	//initalize the 
	private TweetService myTweetService = new TweetService();
	// Vater von TweetService ist Object die grünen Optionen sind vom Object, die gelben, sind die methoden die ich geschrieben habe
	
	private Tweet myTweet01 = new Tweet("hallo yusef");
	
	
	@Test
	public void testSave() {
		myTweetService.save(myTweet01);
		Tweet mymessage = myTweetService.findById(myTweet01.id);
		assertEquals(myTweet01.text, mymessage.text);
// 		assertEquals (expected output/ method to be tested )
		assertEquals(1, myTweetService.size());
		
		myTweetService.delete(myTweet01.id);
		assertEquals(null, myTweetService.findById(myTweet01.id));
		assertEquals(0, myTweetService.size());
		
	}

}
