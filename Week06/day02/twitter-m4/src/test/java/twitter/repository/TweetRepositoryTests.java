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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import twitter.domain.Tweet;

/**
 * Integration tests for the {@link JdbcTweetRepository}, running
 * against an in-memory <em>test</em> database.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
public class TweetRepositoryTests {

	@Autowired
	TweetRepository repository;

	private int initialTweetCount;

	@Before
	public void trackInitialTweetCount() {
		initialTweetCount = repository.count();
	}

	@Test
	public void save() {
		repository.save(new Tweet("jane", "Hello, Twitter!"));
		assertNumTweets(initialTweetCount + 1);
	}

	@Test
	public void deleteById() {
		repository.deleteById(1);
		assertNumTweets(initialTweetCount - 1);
	}

	@Test
	public void deleteAll() {
		assertThat(initialTweetCount).isGreaterThan(0);
		repository.deleteAll();
		assertNumTweets(0);
	}

	@Test
	public void findById() {
		Tweet tweet = repository.findById(1);
		assertThat(tweet.getAuthor()).isEqualTo("jsmith");
		assertThat(tweet.getText()).isEqualTo("Hello, World!");
	}

	@Test
	public void findAll() {
		List<Tweet> tweets = repository.findAll();
		assertThat(getTweetTexts(tweets)).containsExactlyInAnyOrder("Hello, World!", "Progamming is fun",
			"#Spring makes develping #Java apps easier", "#JUnit makes testing #Java apps easier",
			"@SpringFramework 4.3.6 released! #Java #Spring", "Do, or do not; there is no try.");
	}

	@Test
	public void findAllByUsernameWithExactMatch() {
		List<Tweet> tweets = repository.findAllByUsername("jsmith");
		assertThat(getTweetTexts(tweets)).containsExactlyInAnyOrder("Hello, World!", "Progamming is fun",
			"#Spring makes develping #Java apps easier", "#JUnit makes testing #Java apps easier",
			"@SpringFramework 4.3.6 released! #Java #Spring");
	}

	@Test
	public void findAllByUsernameIgnoringCase() {
		List<Tweet> tweets = repository.findAllByUsername("JSmith");
		assertThat(getTweetTexts(tweets)).containsExactlyInAnyOrder("Hello, World!", "Progamming is fun",
			"#Spring makes develping #Java apps easier", "#JUnit makes testing #Java apps easier",
			"@SpringFramework 4.3.6 released! #Java #Spring");
	}

	@Test
	public void findAllContainingWithExactMatch() {
		List<Tweet> tweets = repository.findAllContaining("World");
		assertThat(getTweetTexts(tweets)).containsExactly("Hello, World!");
	}

	@Test
	public void findAllContainingIgnoringCase() {
		List<Tweet> tweets = repository.findAllContaining("world");
		assertThat(getTweetTexts(tweets)).containsExactly("Hello, World!");
	}

	@Test
	public void findAllUsernames() {
		assertThat(repository.findAllUsernames()).containsExactlyInAnyOrder("jsmith", "yoda");
	}

	private void assertNumTweets(int expected) {
		assertThat(repository.count()).isEqualTo(expected);
	}

	private List<String> getTweetTexts(List<Tweet> tweets) {
		return tweets.stream().map(Tweet::getText).collect(toList());
	}

}
