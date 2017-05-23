package factoryMethods;

public class OuterClassWithStaticNestedClass {
	private int private_member_variable = 100;

	public static class StaticInnerClass {
		public void printPrivateVariables() {
			OuterClassWithStaticNestedClass outerClass = new OuterClassWithStaticNestedClass();
			System.out.println(outerClass.private_member_variable);
		}
	}
}
