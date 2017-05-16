package LombokExample;


public class Main {

	public static void main(String[] args) {
		
		Address adress = new Address("Switzerland", "Zurich", 8050, "Dialogweg", 7);
		Person simona = new Person("Simona", "Muehlebach", adress);
		
		System.out.println(simona.toString());
		
	}
}

