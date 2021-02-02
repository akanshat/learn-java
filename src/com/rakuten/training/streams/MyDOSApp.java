package com.rakuten.training.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.rakuten.training.basics.ChemicalElements;

public class MyDOSApp {

	private static ChemicalElements[] elementsArray = { new ChemicalElements("Hydrogen", "H", 1),
			new ChemicalElements("Postassium", "K", 19), new ChemicalElements("Oxygen", "O", 8) };

	private static List<ChemicalElements> elementList = Arrays.asList(elementsArray);

	public static void main(String[] args) {
		Stream.of(elementsArray);
		System.out.println("stream.of called");
		elementList.stream().forEach(e -> System.out.println("Name of element: " + e.getName()));

//		inferCommandArguments(args);

	}
}
