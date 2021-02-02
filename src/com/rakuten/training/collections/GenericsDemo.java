package com.rakuten.training.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GenericsDemo {

	public static <T> void sort(List<T> l, Comparator<? super T> c) {
		// here <T> before void only means that it is a Generic method
		// comparator c can be of the type of the parent of type of List l
		// this is where a lowerbound wildcard will come
		// ? super means parent type of first arg
	}

//	public static Object findAnInterestingElement(List l) {
	public static <T> T findAnInterestingElement(List<T> l) {
		// this is a GENERIC METHOD, we can know by seeing angular
		// bracket before return type

		/// here return type depends on the arguments type, what ever list it receives
		/// its element it will return
		// we will use GENERIC METHODS <T> T , sum printall werent generic methods, they
		/// just
		/// make use of generics
		// generics methods are methods that define parameter at ...
		// will take List of type T and will return an arg of type T
		return null;
	}

	public static void printAll(List<?> l) {
		// using ? made it readonly type
		// print all
//		l.add("abc");
	}

//	public double sum(List l) { // using raw list is not a good idea
	public static double sum(List<? extends Number> numList) { // this sum method only works with integers now
		// since all numbers a subtype of Number we added <? extends Number> called
		// Upperbounded wildcard
		// now it knows list will be of the type Number but which number it doesnt know
		double sum = 0;
		for (Number i : numList) {
			sum += i.doubleValue();
		}
		return sum;
	}

	public static void main(String[] args) {
		List<Integer> iList = new ArrayList<>();
		iList.add(123);
		iList.get(0);

		iList.add(234);
		printAll(iList);
		for (Integer i : iList) // this is allowed even whe nprintall has .add("string"), which is not correct
								// as this accepts integers
			System.out.println(i);

		double sum = sum(iList);
		System.out.println(sum);

		Object o = new Integer(2);

		List<Double> dList = new ArrayList<>();
		dList.add(1.2);
		dList.add(1.8);
		double dsum = sum(dList); // func sum wont accept doubles
		System.out.println(dsum);
//		List<Object> oList = iList; // not allowed
		// if we do -
//		oList.add("abc"); // this is accepted, but the reference of the object oList is holding only
		// accepts integers
		// therefore it doesnt matter what type you assign

//		List<Object> oList = new ArrayList<Integer>(); // not allowed

		// List<Object> oList = new ArrayList<>(iList); // this will work, because <>
		// will be inferred as <Object>
		// and it has a new ArrayList has parameter type as (? extends the type
		// speicifed on LHS),
	}

}
