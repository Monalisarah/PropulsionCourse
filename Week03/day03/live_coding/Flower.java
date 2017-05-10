
package demo;

public class Flower {

	String color;
	private boolean smellsSweet;

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isSmellsSweet() {
		return this.smellsSweet;
	}

	public void setSmellsSweet(boolean smellsSweet) {
		this.smellsSweet = smellsSweet;
	}

	@Override
	public String toString() {
		return "Flower [color=" + this.color + ", smellsSweet=" + this.smellsSweet + ", getColor()=" + this.getColor()
				+ ", isSmellsSweet()=" + this.isSmellsSweet() + ", getClass()=" + this.getClass() + ", hashCode()="
				+ this.hashCode() + ", toString()=" + super.toString() + "]";
	}

}
