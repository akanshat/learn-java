package com.rakuten.training.basics;

public class StackUser {
	public void fill10(StackInterface s) {
		for (int i = 0; i < 10; i++)
		{	
			s.push(i);
			System.out.println(i + " pushed to stack");
		}
	}
}
