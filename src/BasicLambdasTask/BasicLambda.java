package BasicLambdasTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BasicLambda {
//	public static String betterString(String string1, String string2, TwoStringPredicate decider) {
//		if (decider.isFirstBetterThanSecond(string1, string2)) {
//			return string1;
//		} else {
//			return string2;
//		}
//	}

	public static void effectivelyFinalDemo() {
		int i = 10;
		StringUtils.betterString("hello", "hi", (str1, str2) -> {
			// use only such local variables in the body of the lambda which are as though
			// they are final, i.e., they are assigned once and their value snever changes,
			// they are called effectively final local variables
			System.out.println(i);
			return str1.length() > str2.length();
		});
//		i++; line 23, sysout wont compile
	}

	public static void main(String[] args) {
		effectivelyFinalDemo();
		List<String> words = new ArrayList<>();

		words.add("cdefg");
		words.add("efghij");
		words.add("abc");
		words.add("bcde");

		// List<String> increasingLength = words;
		Collections.sort(words, (e1, e2) -> e1.length() - e2.length());
		System.out.println(words);

		Collections.sort(words, (e1, e2) -> e2.length() - e1.length());
		System.out.println(Arrays.asList(words));

		Collections.sort(words, (e1, e2) -> e1.charAt(0) - e2.charAt(0));
		System.out.println(Arrays.asList(words));

		Collections.sort(words, (e1, e2) -> {
			if (e1.contains("e") && !e2.contains("e"))
				return -1;
			else if (e2.contains("e") && !e1.contains("e"))
				return 1;
			else
				return 0;
		});
		System.out.println(words);

		Collections.sort(words, StringUtils::eChecker);
		System.out.println(words);

		// instance method
//		StringUtils obj = new StringUtils();
//		Collections.sort(words, obj::eChecker);
//		System.out.println("instance method");
//		System.out.println(words);

		String s1 = "abcd", s2 = "xyz";

		// Lambda's scope can is the scope as this, they are lexically scoped
		// that is objects scope is lambdas scope

		// in case of Anonymous inner class this would refer to its own scope
		// but in lambda this refers to main here, object i.e, of the enclosing method
		String longerString = StringUtils.betterString(s1, s2, (str1, str2) -> str1.length() > str2.length());
		System.out.println("betterString " + longerString);

		// same utility but generic
		String longerElement = StringUtils.betterEntry(s1, s2, (str1, str2) -> str1.length() > str2.length());
		System.out.println("betterElement " + longerElement);
	}

}
