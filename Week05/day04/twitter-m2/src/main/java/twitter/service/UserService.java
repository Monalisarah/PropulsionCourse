package twitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twitter.repository.TweetRepository;
@Service
public class UserService {
	
	private final TweetRepository tweetRepository;

	@Autowired
	public UserService(TweetRepository tweetRepository) {
		this.tweetRepository = tweetRepository;
	}
		
		
	List<String> findAllUsernames(){
		return tweetRepository.findAllUsernames();
	}
	
}
