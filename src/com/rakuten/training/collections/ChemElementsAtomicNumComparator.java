package com.rakuten.training.collections;

import java.util.Comparator;

import com.rakuten.training.basics.ChemicalElements;

public class ChemElementsAtomicNumComparator implements Comparator<ChemicalElements> {

	@Override
	public int compare(ChemicalElements c1, ChemicalElements c2) {
		if (c1.getAtomicNumber() > c2.getAtomicNumber())
			return 1;
		else if (c1.getAtomicNumber() < c2.getAtomicNumber())
			return -1;
		else
			return 0;
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
