package exercises;

public class PeopleMain {
	
	public static void printPeople(Person[] ArrayofPersons){  // ArrayofPersons is a placeholder wich will have the content of any Argument passed to this function
		for (Person eachPerson : ArrayofPersons)
			System.out.println(eachPerson);
		
	}

	public static void main(String[] args) {  // an Array of Strings named args
		Person person1 = new Person("Simona", "Mühlebach", 30);
		Person person2 = new Person("Sarah", "Meier", 15);
		Person person3 = new Person("Sarah", "Meier", 15);
		Person[] peopletzuftz = {person1, person2, person3};  //Array of Persons named people

		printPeople(peopletzuftz);
	
	}
	
}
