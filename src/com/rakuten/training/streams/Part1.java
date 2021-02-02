package com.rakuten.training.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.rakuten.training.collections.SortDemo;

public class Part1 {

	private static void printString(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		System.out.println(SortDemo.strings);
//		List<String> words = new ArrayList<>();
		String[] words = SortDemo.strings;

		System.out.println(Arrays.asList(words));
		Stream.of(words).forEach(w -> System.out.println("  " + w));

		Stream.of(words).forEach(Part1::printString);
		Stream.of(words).forEach(System.out::println);

		List<String> excitingWords = Stream.of(words).map(s -> s + '!').collect(Collectors.toList());
		System.out.println(excitingWords);

		List<String> eyeWords = Stream.of(words).map(s -> s.replace("i", "eye")).collect(Collectors.toList());
		System.out.println(eyeWords);

		List<String> upperCaseWords = Stream.of(words).map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(upperCaseWords);

		List<String> shortWords = Stream.of(words).filter(s -> s.length() < 4).collect(Collectors.toList());
		System.out.println(shortWords);

		List<String> wordsWithB = Stream.of(words).filter(s -> s.contains("b")).collect(Collectors.toList());
		System.out.println(wordsWithB);

		List<String> evenLengthWords = Stream.of(words).filter(s -> (s.length() % 2 == 0)).collect(Collectors.toList());
		System.out.println(evenLengthWords);

	}

}
