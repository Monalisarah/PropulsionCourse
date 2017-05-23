package twitter.service;

import java.util.List;
import java.util.stream.Collectors;

import twitter.domain.Tweet;
import twitter.repository.InMemoryTweetRepository;
import twitter.repository.TweetRepository;

public class TweetService {
	
	TweetRepository tweetRepository = new InMemoryTweetRepository();
	
	public void saveTweet(Tweet tweet){
		tweetRepository.save(tweet, tweet.getId());
	}
	public void deleteTweet(String id){
		tweetRepository.deleteById(id);
	}
	public Tweet findTweet(String id){
		return tweetRepository.findById(id);
	}
	public List<Tweet> findAllTweets(){
		return tweetRepository.findAll();
	}
	public List<Tweet> findAllTweetsByUsername(String username){
		List<Tweet> tweetList = findAllTweets();
		return tweetList.stream().filter(tweet -> tweet.getAuthor().getUserName().equals(username)).collect(Collectors.toList());
	}
	public List<Tweet> findAllTweetsByUserId(String userId){
		List<Tweet> tweetsByUser = findAllTweets();
		return tweetsByUser.stream().filter(tweet -> tweet.getAuthor().getId().equals(userId)).collect(Collectors.toList());
	}

}
