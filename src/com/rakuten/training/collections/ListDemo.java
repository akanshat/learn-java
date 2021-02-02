package com.rakuten.training.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ListDemo {

	public static void myAlgo(ArrayList<String> l) {
//	public static void myAlgo(List<String> l) {
//	public static void myAlgo(Collection<String> l) {
		// trying random access using Array List

		l.add("abc");
		l.add("test");
		l.get(1);

		// I realize that I dont want to use ArrayList, but a LinkedList
		// How des this function evolve
		// it wont work
		// not easy to swap from one list to another by being tightly coupled with one
		// concrete type
		// therefore we need loose coupling
		// there fore ArrayList -> List, then we can swtich to using LL
		// therefore we have Interfaces and concrete classes

		// looping over a list
//		int size = l.size();

		// while this works, it is inefficient
//		for (int i = 0; i < size; i++) {
//			String s = l.get(i); // this .get is a random access operation, will work with 
//			//list but it wont work with a Collection type specified
//			System.out.println(s);
//		}

		// if it is not a List but some other type of Collection
		// .get . add works with lists not all Collections
		// so we set up something that works with all -> Iterator

		// instead of using a loop
		// each concrete data structure has its own implementation of an iterator
		Iterator<String> it = l.iterator(); // this l.iterator() returns the iterator of that collection, it gives its
											// efficient iterator
		while (it.hasNext()) {
			String s = it.next(); // it will return the next element and move the cursor to next element
			System.out.println(s);

			// remove of length 3
//			if (s.length() == 3) {
//				l.remove(s);
				// removing directly from the collection will change indices
//				// the moment i remove something all indices change
//			}

			if (s.length() == 3) {
				// we remove it from the iterator , not directly from the collection
				it.remove();
			}

		}
//		System.out.println("remaining list: ");
//		System.out.println(l);

		// enhanced for loop -> forEach can be used 
		//on any collection and even on all arrays
		// as EFFICIENT as an iterator
		System.out.println("enhanced for loop -> forEach");
		for (String s : l) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		demoRawList();

		demoSpecificList();

		demoAutoBoxing();

		ArrayList<String> l = new ArrayList<>();
		myAlgo(l);

	}

	private static void demoAutoBoxing() {
		List<Integer> iList = new ArrayList<>();
		iList.add(1);
		iList.add(2);
		iList.add(3);
		iList.add(4);

		iList.remove(2);// 2 is always treated as an index number because
		// there is indeed a remove method that takes in an integer

		iList.remove(new Integer(2)); // boxing it to remove the value 2

		System.out.println(iList);
	}

	private static void demoSpecificList() {
//		List<String> sList = new ArrayList<String>(); can also be written as below line
		List<String> sList = new ArrayList<String>();
		sList.add("Hello!");
		String s = sList.get(0);
		System.out.println(s);
	}

	private static void demoRawList() {
		List l = new ArrayList();
		l.add("hello");
		l.add(1); // internally converted into: l.add(new Integer(1))
		l.add(4.0); // l.add(new Double(42.0))

		System.out.println(l.size());
		System.out.println(l.get(2));
//		String s = (String) l.get(1); // typecasting, will give an error
//		System.out.println(s);

		String s = l.get(2) + " test"; // wont give an error
		System.out.println(s);

	}
}
