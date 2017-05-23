package twitter.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import twitter.domain.User;

public class UserTest {

	@Test
	public void test() {
		User user01 = new User("KarstenNordhausen", "karsten@me.com","TwitterKarsten", "mySecurePW");
		System.out.println(user01.toString());
		assertEquals("KarstenNordhausen", user01.getFullName());
		
		
	}

}
