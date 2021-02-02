package com.rakuten.training.collections;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetDemo {
	public static void main(String[] args) {
		demoHashSet();
	}

	private static void demoHashSet() {
		Set<String> uniqueWords = new LinkedHashSet<>();
		// try with resources
		// telling the compiler, this try block uses these resources, please close it
		// after try
		try (Scanner kb = new Scanner(System.in);) {
			while (true) {
				System.out.println("Enter a word: ");
				String aWord = kb.nextLine();
				// if(aWord=="quit") // worse way to compare string, always evaluate to false
				if (aWord.equalsIgnoreCase("quit"))
					break;
				if (!uniqueWords.add(aWord)) {
					// add returns a boolean, true if added else false
					System.out.println("Thats a duplicate!");
				}
			}
			// different oder as inserted because of hashcode it will be placed at different
			// positions
			System.out.println("___________________________________________");
			for (String s : uniqueWords) {
				System.out.println(s);
			}
		}
//		finally {
//			kb.close();
//		}
	}
}
