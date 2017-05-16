package Bank;

import java.util.UUID;

public class Customer {
	
	//fields
	protected final String name;
	protected final String id = UUID.randomUUID().toString(); 
	protected Account account;

	//constructor
	protected Customer(String name){
		this.name = name;
	}

	//getters and setters
	public Account getAccount() {
		return this.account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getName() {
		return this.name;
	}
	public String getId() {
		return this.id;
	}

	

	// toString
	@Override
	public String toString() {
		return "Customer [name=" + this.name + ", id=" + this.id + ", accountBalance=" +(this.account == null? "null": this.account.balance) + "]";
	}


	

}
