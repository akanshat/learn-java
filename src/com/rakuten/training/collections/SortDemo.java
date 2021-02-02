package com.rakuten.training.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.rakuten.training.basics.ChemicalElements;

public class SortDemo {
	public static String[] strings = { "this", "is", "a", "bunch", "of", "bizzare", "words", "like", "xylophone" };

	public static void main(String[] args) {
		demoSimpleSortOfStrings();

		demoSortOfUserDefinedClass();
	}

	private static void demoSortOfUserDefinedClass() {
		ChemicalElements h = new ChemicalElements("Hydrogen", "H", 1);
		ChemicalElements o = new ChemicalElements("Oxygen", "O", 8);
		ChemicalElements k = new ChemicalElements("Potassium", "K", 19);
		ChemicalElements zn = new ChemicalElements("Zinc", "Zn", 30);

		List<ChemicalElements> cList = new ArrayList<>();
		cList.add(k);
		cList.add(zn);
		cList.add(o);
		cList.add(h);
		System.out.println(cList);
//		Collections.sort(cList);
		System.out.println(cList);
		// given 2 chemical elements we should be able to determine how to compare them,
		// not whether they are equal or not

		// compare using comparator instead of comparable, we designed our own

//		Collections.sort(cList, new ChemElementsAtomicNumComparator());
		System.out.println(cList);

		// instead of writing a new class ( because it is onlt being instantiated once)
		// we use anonymous inner class functions

		// to sort by length of name, we can either create a new class or use
		// anonymous inner classes
//		Collections.sort(cList, new Comparator<ChemicalElements>() {
//			@Override
//			public int compare(ChemicalElements o1, ChemicalElements o2) {
//				return o1.getName().length() - o2.getName().length();
//			};
//		});
		// same as this ^
		Collections.sort(cList, (o1, o2) -> o1.getName().length() - o2.getName().length());
		System.out.println(cList);
	}

	private static void demoSimpleSortOfStrings() {
//		List<String> wordList = Arrays.asList(strings);

		List<String> wordList = new ArrayList<>(Arrays.asList(strings));
//		System.out.println(strings);
//		System.out.println(wordList);

		// sorting the string array
//		Arrays.sort(strings);
//		System.out.println(Arrays.asList(strings));

		// sorting the list
		Collections.sort(wordList);
		System.out.println(wordList);
		for (String s : strings)
			System.out.println(s); // still sorted if we only use Arrays.asList, then it will internally use
									// strings, and it will then sort original too
		// special behavior of arrays.asList

		// if I don't want it to touch the internal array, don't sort it then
		// new ArrayList, that takes in this list as constructor, this arraylist
		// constructor will copy the elements into an array it internally maintains
	}

}
