
package demo;

public class InheritanceDemo {

	public static void main(String[] args) {

		// Number num1 = new Integer(42);
		Number num1 = fromOtherUser();
		Number num2 = fromUser();

		if (num2 instanceof Double) {
			System.out.println("num2 is a Double");
			Double castDouble = (Double) num2;
			boolean infinite = castDouble.isInfinite();
			System.out.println("num2 is infinite: " + infinite);
		}
		else {
			System.out.println("num2 is not a Double");
		}

		if (num1 instanceof Double) {
			System.out.println("num1 is a Double");
		}
		else {
			System.out.println("num1 is not a Double");
		}

	}

	private static Integer fromOtherUser() {
		return new Integer(42);
	}

	private static Double fromUser() {
		return Double.POSITIVE_INFINITY; // new Double(3.14);
	}

}
