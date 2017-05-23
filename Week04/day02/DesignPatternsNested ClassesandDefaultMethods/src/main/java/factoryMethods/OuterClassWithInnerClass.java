package factoryMethods;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class OuterClassWithInnerClass {
	private int private_member_variable = 100;

	private List<Rectangle> rectangles = new ArrayList<Rectangle>();

	public void callInnerClassMethod() {
		InnerClass innerClass = new InnerClass();
		innerClass.printPrivateVariable();
	}

	public class InnerClass {
		public void printPrivateVariable() {
			System.out.println(private_member_variable);
		}
	}

	@Data
	public class Rectangle {
		private int x;
		private int y;

		private int getArea() {
			return x * y;
		}
	}
}

// innerclass can only be acessed on an instance of outer class
