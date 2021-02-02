package com.rakuten.training.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.rakuten.training.basics.ChemicalElements;

public class MapDemo {
	public static void main(String[] args) {
		demoSimpleMapOps();

		demoMapofUserDefinedKeyType();
	}

	private static void demoSimpleMapOps() {
		Map<String, Integer> runs = new HashMap<>();
		runs.put("Virat", 100);
		runs.put("Bhuvi", 50);
		runs.put("Rohit", 32);

		System.out.println("Is there a batsman called Rohit? " + runs.containsKey("Rohit"));
		System.out.println("Anyone scored exact 100? " + runs.containsValue(100));
		System.out.println("How many runs for Bhuvi? " + runs.get("Bhuvi"));
		System.out.println("How many runs for Jinx? " + runs.get("Jinx"));
	}

	private static void demoMapofUserDefinedKeyType() {
		ChemicalElements o = new ChemicalElements("Oxygen", "O", 8);
		ChemicalElements k = new ChemicalElements("Potassium", "K", 19);
		ChemicalElements zn = new ChemicalElements("Zinc", "Zn", 30);

		Map<ChemicalElements, Double> earthComposition = new HashMap<>();
		earthComposition.put(o, 41.0);
		earthComposition.put(k, 0.5);
		earthComposition.put(zn, 1.1);

		// hardcoded, we want to prompt the user to enter the atomic number
		// then create a chemical element and the query the map to find out the % of
		// composition
		// System.out.println("how much is of earth oxygen? " +
		// earthComposition.get(o));

		Scanner kb = new Scanner(System.in);
//		while (true) {
		System.out.println("Enter an atomic number of test: ");
		int num = Integer.parseInt(kb.nextLine());

		ChemicalElements anUnknownElement = new ChemicalElements(null, null, num);
//		System.out.println(anUnknownElement.hashCode());
		System.out.println("Do I know how much of earth the element with atomic number " + num + " is");
		System.out.println(earthComposition.containsKey(anUnknownElement));
		// an object by default is only similar to itself
		// since we are doing "new" here it is creating a new object, different object
		// so we have to override equals and override method here so that equality is
		// determined based on atomic number
		// override these methods in ChemicalElements.java class
//		}

		if (earthComposition.containsKey(anUnknownElement)) {
			double percentage = earthComposition.get(anUnknownElement);
			System.out.println(percentage + "% of earth is element with atomic number " + num);
		}

	}

}
