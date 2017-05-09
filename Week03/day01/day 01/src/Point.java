

public class Point {
	//properties of the class
	public static final String COLOR = "black"; // static final -> constant immutable variable

	private final int x;  // final -> immutable -> once you define it you can not change it
	private final int y; // all the properties which are final must be defined when we create an Instance
	
	//constructor default
	private Point() {
		this.x = 0;
		this.y = 0;
	}
	// constructor with two parameters, initializing both properties
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}

}


