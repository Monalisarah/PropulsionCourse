package Bank;

import static org.junit.Assert.*;

import org.junit.Test;

public class BankTest {
	
	Customer customer01 = new Customer("Simona");
	Account account01 = new Account(customer01);

	@Test
	public void test() {
		//customer01.setAccount(account01);
		account01.credit(100.00);
		assertEquals(100.00, account01.balance, 0.00);
		account01.debit(20.00);
		System.out.println(account01.balance);
		assertEquals(80.00, account01.balance, 0.00);
		
		assertEquals("Simona", customer01.name);
		assertEquals("Simona", account01.customer.name);
		
		assertEquals( 80.00, customer01.account.balance, 0.00);
		
	}

}
