package stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfDemo {
	public static void main(String[] args) {

		Stream.of("A", "B", "C").forEach(System.out::println);
		long count = Stream.of("A", "B", "C").count();
		System.out.println(count);
		Stream.of("A", "B", "C").filter(a -> a == "C" || a == "A").forEach(System.out::println);
		Stream.of(1, 2, 3, 4, "a", "b").filter(i -> i instanceof Integer).forEach(System.out::println);
		System.out.println(IntStream.of(1, 2, 3, 4, 5).min());
		System.out.println(IntStream.of(1, 2, 3, 4, 5).max());
		System.out.println(IntStream.of(1, 2, 3, 4, 5).sum());
		System.out.println(IntStream.of(1, 2, 3, 4, 5).average());

		IntSummaryStatistics stats = IntStream.of(1, 2, 3, 4, 5, 6).peek(System.out::println).summaryStatistics();

		IntSummaryStatistics stats01 = IntStream.of(1, 2, 3, 4, 5, 6).limit(3).peek(System.out::println)
				.summaryStatistics();
		System.out.println(stats01);
		

		IntSummaryStatistics stats02 = IntStream.of(5, 6, 7, 8, 9, 10).skip(5).peek(System.out::println)
				.summaryStatistics();
		System.out.println(stats02);

		banner(".filter");
		int[] evens = IntStream.iterate(1, n -> n + 1).filter(i -> i % 2 == 0).limit(20).toArray();
		System.out.println(Arrays.toString(evens));

		
	}

	private static void banner(String header) {
		System.out.println();
		System.out.println("=================================================");
		System.out.println("=== " + header);
		System.out.println("=================================================");
	}

}
