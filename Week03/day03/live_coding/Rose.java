
package demo.sub;

import demo.Flower;

public class Rose extends Flower {

	private final boolean isThorny = true;

	public boolean isThorny() {
		return this.isThorny;
	}

	@Override
	public String toString() {
		// Rose cannot see super.color
		//		return "Rose [isThorny=" + this.isThorny + ", color=" + super.color + ", isSmellsSweet()="
		//				+ this.isSmellsSweet() + "]";
		return "Rose [isThorny=" + this.isThorny + ", color=" + getColor() + ", isSmellsSweet()=" + this.isSmellsSweet()
				+ "]";
	}

}
