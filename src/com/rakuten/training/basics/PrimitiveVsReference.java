package com.rakuten.training.basics;
/** 
 * Bootcamp- Jan 28
 * */
public class PrimitiveVsReference {

	static int class_level_x; // global variable can be used without initialization

	// primitives are never null-> true
	// primitives always have a value -> false
	
	public static void f1(int i) {
		// do something with i
//		int test; // initialization is required, compile error
		System.out.println("line 6");
	}

	public static void f1(long i) {
		// do something else with i
		System.out.println("line 11");
	}

	public static void main(String[] args) {
		
		class_level_x++;
		System.out.println(class_level_x);
		
		
		
		int i = 4;

		someFun1(i);
		System.out.println(i);

		f1(100L); // literal, 100L means long

//		long someLong = 100;

		Integer intObj = new Integer(i);
//		Integer intObj = i; // since it it depreciated in above line

		int[] nums = new int[10]; // all values are 0 by default, for new object they are null
		nums[0] = 20;
		someFun2(nums);
		System.out.println(nums[0]);
	}

	private static void someFun1(int someNum) {
		someNum++;
	}

	private static void someFun2(int someNums[]) {
		someNums[0]++;
	}
}
