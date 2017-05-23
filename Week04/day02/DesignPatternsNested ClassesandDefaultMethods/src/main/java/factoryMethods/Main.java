package factoryMethods;

import factoryMethods.OuterClassWithInnerClass.InnerClass;
import factoryMethods.OuterClassWithStaticNestedClass.StaticInnerClass;

public class Main {

	public static void main(String args[]) {
		OuterClassWithInnerClass myOuterClass1 = new OuterClassWithInnerClass();
		myOuterClass1.callInnerClassMethod();

		OuterClassWithInnerClass myOuterClass2 = new OuterClassWithInnerClass();
		myOuterClass2.callInnerClassMethod();

		// innerclass can only be acessed on an instance of outer class
		// InnerClass innerClass = new InnerClass(); 

		StaticInnerClass staticInnerClass = new StaticInnerClass();
		staticInnerClass.printPrivateVariables();

	}
}
