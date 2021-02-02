package com.rakuten.training.streams;

import java.util.Arrays;
import java.util.List;

import com.rakuten.training.collections.SortDemo;

public class Part2 {

	public static void main(String[] args) {
		List<String> words = Arrays.asList(SortDemo.strings);

		String ul = words.stream().reduce("", (s1, s2) -> s1.toUpperCase().concat(s2.toUpperCase()));
		System.out.println(ul);

		String ml = words.stream().map(s -> s.toUpperCase()).reduce("", (s1, s2) -> s1.concat(s2));
		System.out.println(ml);

		String cl = words.stream().reduce((s1, s2) -> s1 + "," + s2).orElse("need 2 strs");
		System.out.println(cl);
	}

}
