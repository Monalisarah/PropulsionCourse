
package demo;

public class Tulip extends Flower {

	private int numPetals;

	public int getNumPetals() {
		return this.numPetals;
	}

	@Override
	public String getColor() {
		return "Extra vivid color: " + super.getColor();
	}

	public void setNumPetals(int numPetals) {
		this.numPetals = numPetals;
	}

	@Override
	public String toString() {
		return "Tulip [numPetals=" + this.numPetals + ", getColor()=" + super.color + ", isSmellsSweet()="
				+ isSmellsSweet() + "]";
	}

}
