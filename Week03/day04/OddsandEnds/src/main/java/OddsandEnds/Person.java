package OddsandEnds;

import java.util.*;

public class Person implements Animal {

	// fields
	
	private final String firstName;
	private final String lastName;
	private final int age;
	private final List<Pet> petsList = new ArrayList<>();
	
	// constructor
	
	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	@Override
	public String speak() {
		return "Hello!";
	}

	@Override
	public String getName() {
		return this.firstName + " " + this.lastName;
	}

}
