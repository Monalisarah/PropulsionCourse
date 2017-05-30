/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package twitter.repository;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import twitter.config.TestDataAccessConfig;
import twitter.domain.Tweet;

/**
 * Integration tests for the {@link JdbcTweetRepository}, running
 * against the <em>production</em> database.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TestDataAccessConfig.class, RepositoryConfig.class })
@ActiveProfiles("dev")
@Transactional
@Sql("/test-data.sql")
public class TweetRepositoryTests {
	
	private static final int NUM_TWEETS = 5;

	@Autowired
	TweetRepository repository;

//	@Before
//	@After
//	public void clearTweetTable() {
//		repository.deleteAll();
//		assertNumTweets(0);
//	}

	@Test
	public void save() {
		saveTweet1();
		assertNumTweets(NUM_TWEETS + 1);
	}

	@Test
	public void deleteById() {
		// Integer id = repository.findAll().get(0).getId();
		// repository.deleteById(id);
		repository.deleteById(1);
		assertNumTweets(NUM_TWEETS-1);
	}

	@Test
	public void deleteAll() {
		saveTweet1();
		saveTweet2();
		assertNumTweets(NUM_TWEETS+2);
		repository.deleteAll();
		assertNumTweets(0);
	}

	@Test
	public void findById() {
		saveTweet1();
		assertNumTweets(NUM_TWEETS+1);
		Integer id = 1;
		Tweet tweet = repository.findById(id);
		assertThat(tweet.getAuthor()).isEqualTo("jsmith");
		assertThat(tweet.getText()).isEqualTo("Hello, World!");
	}

	@Test
	public void findAll() {
		Tweet tweet1 = saveTweet1();
		Tweet tweet2 = saveTweet2();
		assertNumTweets(NUM_TWEETS+2);
		assertThat(repository.findAll()).contains(tweet2, tweet1);

		// List<String> tweetTexts = repository.findAll().stream().map(Tweet::getText).collect(toList());
		// assertThat(tweetTexts).containsExactlyInAnyOrder("Hello, Twitter!", "2nd tweet");
	}

	@Test
	public void findAllByUsernameWithExactMatch() {
		save3Tweets();
		// @formatter:off
		List<String> tweetTexts = repository.findAllByUsername("jsmith")
				.stream()
				.map(Tweet::getText)
				.collect(toList());
		// @formatter:on
		assertThat(tweetTexts).contains("Hello, Twitter!", "2nd tweet");
	}

	@Test
	public void findAllByUsernameIgnoringCase() {
		save3Tweets();
		// @formatter:off
		List<String> tweetTexts = repository.findAllByUsername("JSmith")
				.stream()
				.map(Tweet::getText)
				.collect(toList());
		// @formatter:on
		assertThat(tweetTexts).contains("Hello, Twitter!", "2nd tweet");
	}

	@Test
	public void findAllContainingWithExactMatch() {
		save3Tweets();
		// @formatter:off
		List<String> tweetTexts = repository.findAllContaining("Twitter")
				.stream()
				.map(Tweet::getText)
				.collect(toList());
		// @formatter:on
		assertThat(tweetTexts).contains("Hello, Twitter!");
	}

	@Test
	public void findAllContainingIgnoringCase() {
		save3Tweets();
		// @formatter:off
		List<String> tweetTexts = repository.findAllContaining("twitter")
				.stream()
				.map(Tweet::getText)
				.collect(toList());
		// @formatter:on
		assertThat(tweetTexts).contains("Hello, Twitter!");
	}

	@Test
	public void findAllUsernames() {
		save3Tweets();
		assertNumTweets(NUM_TWEETS+3);
		List<String> usernames = repository.findAllUsernames();
		assertThat(usernames).contains("jsmith", "yoda");
	}

	private void save3Tweets() {
		saveTweet1();
		saveTweet2();
		saveTweet3();
		assertNumTweets(NUM_TWEETS+3);
	}

	private void assertNumTweets(int expected) {
		assertThat(repository.count()).isEqualTo(expected);
	}

	private Tweet saveTweet1() {
		Tweet tweet = new Tweet("jsmith", "Hello, Twitter!");
		repository.save(tweet);
		return tweet;
	}

	private Tweet saveTweet2() {
		Tweet tweet = new Tweet("jsmith", "2nd tweet");
		repository.save(tweet);
		return tweet;
	}

	private void saveTweet3() {
		repository.save(new Tweet("yoda", "Do, or do not; there is no try."));
	}

}
