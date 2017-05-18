/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package needleInAHaystack;

import java.util.Arrays;
import java.util.Random;

public class NeedleInHaystack {

	private static final int NEEDLE = 42; // 4000
	private static final int HAYSTACK_SIZE = 10; // 100

	private static final Random random = new Random();

	private static int numStepsInAlgorithm = 0;

	public static void main(String[] args) throws Exception {
		int[] haystack = new int[HAYSTACK_SIZE];

		// Add needle to haystack
		haystack[0] = NEEDLE;

		// Add random numbers to haystack
		for (int i = 1; i < haystack.length; i++) {
			haystack[i] = random.nextInt(HAYSTACK_SIZE * HAYSTACK_SIZE) + 1;
		}

		Arrays.sort(haystack);

		System.out.println("Needle:   " + NEEDLE);
		System.out.println("Haystack: " + Arrays.toString(haystack));
		System.out.println();

		final int index = findNeedleInHaystack(NEEDLE, haystack);
		if (haystack[index] != NEEDLE) {
			System.out.println("ERROR: Needle is NOT at index: " + index);
		} else {
			System.out.println("Found needle at index: " + index);
		}

		System.out.println();
		System.out.println("Algorithm took " + numStepsInAlgorithm + " steps.");
	}

	/**
	 * Finds the index of the needle in the haystack.
	 */
	// public static int findNeedleInHaystack(int needle, int[] haystack) {
	// for (int i = 0; i < haystack.length; i++) {
	// numStepsInAlgorithm++;
	// if ( haystack[i] == NEEDLE){
	// return i;
	// }
	// }
	// return -1;
	// }

	public static int findNeedleInHaystack(int needle, int[] haystack) {

		int middle = haystack.length / 2;
		int start = 0;
		int end = haystack.length - 1;
		while (start <= end) {
			System.out.println("middle: " + middle);
			numStepsInAlgorithm++;
			if (needle == haystack[middle]) {
				return middle;
			} else if (needle < haystack[middle]) {
				end = middle;  
				middle = middle/2;
			} else {
				start = middle;
				middle += middle/2;
			}
		
		}
		return -1;
	}

}
