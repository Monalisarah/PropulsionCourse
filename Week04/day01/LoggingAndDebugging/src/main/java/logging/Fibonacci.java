package logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import java.util.logging.Logger;

public class Fibonacci {

//	private static final Logger logger = Logger.getLogger(Fibonacci.class.getName()); JUL Java Util Logging
	private static final Logger logger = LogManager.getLogger(Fibonacci.class);
	/*
	 * static int fibonacci(int n) { if (n == 0) { return 0; }
	 * 
	 * if (n == 1) { return 1; }
	 * 
	 * //int fib = fibonacci(n - 2) + fibonacci(n - 1);
	 * 
	 * return fibonacci(n - 2) + fibonacci(n - 1); }
	 */

	/*
	 * static int fibonacci(int n) {
	 * 
	 * if (n == 0) { return 0; }
	 * 
	 * if (n == 1) { return 1; }
	 * 
	 * int[] fibonacciRow = new int[n + 1]; fibonacciRow[0] = 0; fibonacciRow[1]
	 * = 1;
	 * 
	 * for (int i = 2; i <= n; i++) { fibonacciRow[i] = fibonacciRow[i - 2] +
	 * fibonacciRow[i - 1]; }
	 * 
	 * return fibonacciRow[n]; }
	 */

	static int fibonacci(int n) {

		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		int[] fibonacciRow = new int[3];
		fibonacciRow[0] = 0;
		fibonacciRow[1] = 1;

		for (int i = 2; i <= n; i++) {

			fibonacciRow[i % 3] = fibonacciRow[(i - 2) % 3] + fibonacciRow[(i - 1) % 3];
		}

//		logger.info("This is a log message");
		logger.debug("Hello, Logging!");
		return fibonacciRow[n % 3];
	}

	/*
	 * public static void main(String... args) {
	 * System.out.println(fibonacci(0)); // 0 System.out.println(fibonacci(1));
	 * // 1 System.out.println(fibonacci(2)); // 1
	 * System.out.println(fibonacci(3)); // 2 System.out.println(fibonacci(7));
	 * // 13 System.out.println(fibonacci(12)); // 144
	 * System.out.println(fibonacci(100000)); }
	 */

	public static void main(String... args) {
		// if (args.length == 0) {
		// System.err.println("Error: you must supply which Fibonacci number to
		// compute");
		// System.exit(1); // terminal echo $?
		// }
		// System.out.println("arg: " + args[0]);
		// int i = Integer.parseInt(args[0]);
		// System.out.println(fibonacci(i));
		// }
		System.out.println(fibonacci(7));
	}
}