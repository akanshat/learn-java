package com.rakuten.training.collections;

import java.util.ArrayList;
import java.util.List;

public class CopyUtils {

	// WHERE SUPER CAN BE USED
	public static <T> void copyFromFirstToSecond(List<T> from, List<? super T> to) {
		// both lists should be of the same type

	}

	public static <T> void copyFromSecondToFirst(List<? super T> to, List<T> from) {
		// both lists should be of the same type

	}

	public static void main(String[] args) {
		List<Object> oList = new ArrayList<>();
		List<Integer> iList = new ArrayList<>();
		List<Number> nList = new ArrayList<>();
		copyFromFirstToSecond(iList, oList);
	}

}
