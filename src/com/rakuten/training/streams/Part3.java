package com.rakuten.training.streams;

import java.util.Random;
import java.util.stream.DoubleStream;

public class Part3 {

	private static boolean verify(double d1, double d2) {
		return d1 == d2;
	}

	public static void main(String[] args) {
		double[] dl = new Random().doubles(100).toArray();

		double sum = DoubleStream.of(dl).map(Math::sqrt).reduce(0.0, (n1, n2) -> n1 + n2);
		System.out.println(sum);

		double sumparallel = DoubleStream.of(dl).parallel().map(Math::sqrt).reduce(0.0, (n1, n2) -> n1 + n2);
		System.out.println(sumparallel);

		System.out.println("Are answers obtained EXACTLY SAME? " + verify(sum, sumparallel));
	}
}
