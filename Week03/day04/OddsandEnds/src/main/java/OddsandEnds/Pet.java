package OddsandEnds;

public class Pet implements Animal {
	
	// fields 
	private final String name;
	private final String sound;
	
	
	// constructor
	public Pet(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	// methods
	@Override
	public String speak() {
		return this.sound;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
