package twitter.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import twitter.config.DataAccessConfig;
import twitter.domain.Tweet;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DataAccessConfig.class, RepositoryConfig.class} )
public class TweetRepositoryTests {
	
	@Autowired
	TweetRepository tweetRepository;

	private final Tweet tweet01 = new Tweet( "first Tweet", "Simona");
	private final Tweet tweet02 = new Tweet( "second Tweet", "John");
	private final Tweet tweet03 = new Tweet( "third Tweet", "Simona");
	
	@Before 
	public void setListToZero(){
		tweetRepository.deleteAll();
	}
	
	@Test
	public void save() {
		tweetRepository.save(tweet01);
		assertEquals(1, tweetRepository.count());
		tweetRepository.save(tweet02);
		assertEquals(2, tweetRepository.count());
		
	}
	
	@Test
	public void findById(){
		tweetRepository.save(tweet01);
		Integer id = tweetRepository.findAll().get(0).getId();
		assertEquals(tweet01, tweetRepository.findById(id));
	}
	
	@Test
	public void findAllByUsername(){
		tweetRepository.save(tweet01);
		tweetRepository.save(tweet02);
		tweetRepository.save(tweet03);
		
		List<Tweet> results = tweetRepository.findAllByUsername("Simona");
		
		List<Tweet> expected = Arrays.asList(tweet01, tweet03);
		assertEquals(expected, results);
		
		assertThat(results).contains(tweet01, tweet03);
	}

	
	@Test
	public void findAllContainingString(){
		tweetRepository.save(tweet01);
		tweetRepository.save(tweet02);
		tweetRepository.save(tweet03);
		
		List<Tweet> results = tweetRepository.findAllContaining("Tweet");	
		assertThat(results).contains(tweet01,tweet02, tweet03);
	}
	
	@Test
	public void findAllUsernames(){
		tweetRepository.save(tweet01);
		tweetRepository.save(tweet02);
		
		List<String> results = tweetRepository.findAllUsernames();
		assertThat(results).contains("Simona", "John");
	}
	

//	private void assertNumTweets(int expected) {
//		assertEquals(expected, tweetRepository.count());
//	}

}
