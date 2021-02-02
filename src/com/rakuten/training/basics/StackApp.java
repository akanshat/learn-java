package com.rakuten.training.basics;

public class StackApp {
	public static void main(String[] args) {
		StackUser user = new StackUser();
		
		FixedArrayStack stk = new FixedArrayStack(9);
		
		user.fill10(stk);
	}
}
