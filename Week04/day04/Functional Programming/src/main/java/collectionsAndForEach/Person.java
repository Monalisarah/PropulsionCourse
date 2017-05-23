package collectionsAndForEach;

public class Person {
	
	private final String firstName;
	private final String lastName;
	private Address address;
	
	

	
	public Person(String firstName, String lastName, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Address getAddress() {
		return address;
	}


	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}
	
//	public void setAddress(Address address){
//		this.address = address;
//	}


	
	
	

}
