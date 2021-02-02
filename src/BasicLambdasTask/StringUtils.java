package BasicLambdasTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StringUtils {
	public static int eChecker(String s1, String s2) {
		if (s1.contains("e") && !s2.contains("e"))
			return -1;
		else if (s2.contains("e") && !s1.contains("e"))
			return 1;
		else
			return 0;
	}

	public static String betterString(String s1, String s2, TwoStringPredicate decider) {
		return decider.isFirstBetterThanSecond(s1, s2) ? s1 : s2;
	}

	// ET element type, like T but not of the same type
	public static <ET> ET betterEntry(ET e1, ET e2, TwoElementPredicate<ET> decider) {
		return decider.isFirstBetterThanSecond(e1, e2) ? e1 : e2;
	}

//	public static List<String> allMatches(List<String> l, Predicate<String> predicate) {
//		List<String> newList = new ArrayList<>();
//		for (String s : l) {
//			if (predicate.test(s))
//				newList.add(s);
//		}
//		return newList;
//	}

	public static <T> List<T> allMatches(List<T> list, Predicate<T> predicate) {
		List<T> newList = new ArrayList<>();
		for (T l : list) {
			if (predicate.test(l)) {
				newList.add(l);
			}
		}
		return newList;
	}

	public static <TE, RE> List<RE> transformedList(List<TE> list, Function<TE, RE> function) {
		List<RE> newList = new ArrayList<>();
		for (TE l : list) {
			newList.add(function.apply(l));
		}
		return newList;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("this");
		list.add("is");
		list.add("a");
		list.add("test");
		list.add("string");

		List<String> shortWords = StringUtils.allMatches(list, s -> s.length() < 4);
		System.out.println("shortWords");
		System.out.println(shortWords);

		List<String> wordsWithB = StringUtils.allMatches(list, s -> s.contains("b"));
		System.out.println("wordsWithB");
		System.out.println(wordsWithB);

		List<String> evenLengthWords = StringUtils.allMatches(list, s -> (s.length() % 2) == 0);
		System.out.println("evenLengthWords");
		System.out.println(evenLengthWords);

		List<Integer> nums = Arrays.asList(1, 10, 100, 1000, 10000);
		System.out.println(nums);
//		List<Integer> numberslist = new ArrayList<>();
//		nums.add(1);
//		nums.add(2);
//		nums.add(3);
//		nums.add(4);
//		nums.add(3000);
//		nums.add(4000);
		List<Integer> bigNums = StringUtils.allMatches(nums, n -> n > 500);
		System.out.println(bigNums);

		List<String> eyeWords = StringUtils.transformedList(list, s -> s.replace("i", "eye"));
		System.out.println(eyeWords);
	}
}
