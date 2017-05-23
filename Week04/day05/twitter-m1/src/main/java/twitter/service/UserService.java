package twitter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import twitter.domain.User;
import twitter.repository.InMemoryUserRepository;
import twitter.repository.UserRepository;

public class UserService {

	UserRepository userRepository = new InMemoryUserRepository();

	public void registerNewUser(User user) {
		userRepository.save(user, user.getId());
	}

	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}

	public User findUserById(String id) {
		return userRepository.findById(id);
	}

	// List<User> findUserByUsername(String username){
	// List<User> userList = findAllUsers();
	// return userList.stream().filter(user ->
	// ser.getUserName().collect(Collectors.toList());
	// }
	//
	public User findUserByUsername(String username) {
		List<User> userList = findAllUsers();
		return userList.stream().filter(user -> user.getUserName().equals(username)).collect(Collectors.toList()).get(0);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

}
