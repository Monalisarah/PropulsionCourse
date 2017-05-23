package collectionsAndForEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PersonDemo {
	
	public static void main(String[] args) {
		
		Person person01 = new Person("Yusef", "Habib", new Address("Hauptstrasse", 8050, "Zürich"));
		Person person02	= new Person("Anna", "Widmer", new Address("NamenStrasse", 8000, "Zürich"));
		
		List<Person> people = Arrays.asList(person01, person02);
		
		people.forEach(person -> {System.out.println(person.toString()
				);});
		
		people.forEach(person -> {System.out.println(person.getAddress()
				
				);});
		
		
		people.forEach(System.out :: println);
		
		Map<String, Person> peopleMap = new HashMap<>();
		
		peopleMap.put(person01.getFirstName(),person01);
		peopleMap.put(person02.getFirstName(),person02);
		
		peopleMap.forEach((firstName, person) -> {System.out.println(person.getFirstName());});
		
		
		
		Set<Person> peopleSet = new HashSet<>();
		
		peopleSet.add(person01);
		peopleSet.add(person02);
		peopleSet.forEach(System.out::println);
		peopleSet.forEach(platzhalter-> System.out.println(platzhalter));
		
		
		
	}
	
	

}

