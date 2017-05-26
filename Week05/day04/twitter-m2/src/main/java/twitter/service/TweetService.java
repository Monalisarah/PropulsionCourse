package twitter.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import twitter.domain.Tweet;
import twitter.repository.TweetRepository;

@Service
public class TweetService {

	private final TweetRepository tweetRepository;
	private final JavaMailSender javaMailSender;

	@Autowired
	public TweetService(TweetRepository tweetRepository, JavaMailSender javaMailSender) {
		this.tweetRepository = tweetRepository;
		this.javaMailSender = javaMailSender;
	}
	
	
	void save(Tweet tweet){
		tweetRepository.save(tweet);
	}
	void deleteById(Integer id){
		tweetRepository.deleteById(id);
		
	}
	Tweet findById(Integer id){
		return tweetRepository.findById(id);
		
	}
	List<Tweet> findAll(){
		return tweetRepository.findAll();
		
	}
	List<Tweet> findAllByUsername(String username){
		return tweetRepository.findAllByUsername(username);
		
	}
	List<Tweet> findAllContainingHashTag(String hashTag){
		return tweetRepository.findAllContaining("#" + hashTag);
		
	}
	List<Tweet> findAllMentioningUsername(String username){
		return tweetRepository.findAllContaining("@" + username);
		
	}
}
