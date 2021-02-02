package com.rakuten.training.streams;

import java.util.Arrays;

public class IntStream {
	public static void main(String[] args) {
		Integer[] intObjects = { 1, 2, 3, 4 };
		int[] ints = { 1, 2, 3, 4 };
		System.out.println(Arrays.asList(intObjects));
		System.out.println(Arrays.asList(ints));

		intObjects[0]++; // int temp = intObjects[0].intValue(); temp++; intObjects[0] = new
							// Integer(Temp);
		// unwraps it, increments it, and wraps it again
		// COST is involved

		// here cost is only of ++, working directly with RAW PRIMITIVES
		ints[0]++;
		System.out.println(intObjects[0] + " ------------- " + ints[0]);
	}
}
