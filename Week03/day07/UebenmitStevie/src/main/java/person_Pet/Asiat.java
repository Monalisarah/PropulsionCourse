package person_Pet;

public class Asiat extends Person {
	
	public Asiat(String firstName, String lastName, int age) {
		super(firstName, lastName, age);
	}
	
	@Override
	public String toString() {
		return "I am an asian person! " + super.toString();
	}
}
