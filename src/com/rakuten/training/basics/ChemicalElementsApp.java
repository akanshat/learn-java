package com.rakuten.training.basics;
public class ChemicalElementsApp {

	public static void main(String[] args) {
		ChemicalElements h = new ChemicalElements("Hydrogen", "H", 1);
		System.out.println("Is hydrogen an alkali? " + h.isAlkaliMetal());

		ChemicalElements k = new ChemicalElements("Potassium", "K", 19);
		System.out.println("Is Potassium an alkali? " + k.isAlkaliMetal());
	}

}