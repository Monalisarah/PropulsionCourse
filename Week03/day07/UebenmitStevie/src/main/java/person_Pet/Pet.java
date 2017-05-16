package person_Pet;

public abstract class Pet extends Object implements IAnimal {
	// fields 
	
	private String name;
	private PetType petType;
	
	public Pet(PetType petType, String name){
		this.petType = petType;
		this.name = name;
	}


	@Override
	public String speak() {
		return "I don't speek";
	}	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return petType + " (" + getName() + ")";
	}

}

class Dog extends Pet {
	public Dog(String name) {
		super(PetType.DOG, name);
	}

	@Override
	public String speak() {
		return "Wooff";
	}	
}

class Cat extends Pet {
	public Cat(String name) {
		super(PetType.CAT, name);
	}

	@Override
	public String speak() {
		return "miauww";
	}	
}

class Bird extends Pet {
	public Bird(String name) {
		super(PetType.BIRD, name);
	}
}