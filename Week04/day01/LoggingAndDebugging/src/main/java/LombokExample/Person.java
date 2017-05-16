package LombokExample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString


public class Person {

	String firstName;
	String lastName;
	Address adress;
}


