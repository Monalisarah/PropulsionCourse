package util;


import java.util.stream.IntStream;

public class Factorial {

	static int factorial(int n) {
		if (n < 0) {
            throw new IllegalArgumentException("Only positive values are permitted"); // for exceptions do not use return use throw
        }
		
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static void main(String... args) {
		System.out.println(Factorial.class);
		IntStream.rangeClosed(0, 5).forEach(n -> print(n));
	}

	private static void print(int n) {
		System.out.println(n + "! = " + factorial(n));
	}

}
