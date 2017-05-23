package twitter.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;

import twitter.domain.Tweet;
import twitter.domain.User;

public class UserServiceTest {

	@Test
	public void test() {
		
		User user01 = new User("KarstenNordhausen", "karsten@me.com","TwitterKarsten", "mySecurePW");
		User user02 = new User("Hans", "hans@me.com","TwitterHans", "hansSecurePW");
		UserService myUserService = new UserService();
		
		assertThat(myUserService.findAllUsers()).hasSize(0);
		myUserService.registerNewUser(user01);
		assertThat(myUserService.findAllUsers()).hasSize(1);
		myUserService.registerNewUser(user02);
		assertThat(myUserService.findUserById(user02.getId())).isEqualToComparingOnlyGivenFields(user02);
		assertThat(myUserService.findUserByUsername("TwitterHans")).isEqualTo(user02);
		myUserService.deleteUser(user02.getId());
		assertThat(myUserService.findAllUsers()).hasSize(1);
	}

}
