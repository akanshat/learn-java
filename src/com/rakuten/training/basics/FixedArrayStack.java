package com.rakuten.training.basics;

class FixedArrayStack implements StackInterface {
	private Object[] arr;
	private int top = -1;

	public FixedArrayStack(int capacity) {
		arr = new Object[capacity];
	}

	@Override
	public void push(Object element) {
		try {
			arr[++top] = element;
		} catch (ArrayIndexOutOfBoundsException e) {
			--top;
			throw new StackOverflowException("Stack is full, num of elements  = " + arr.length, e);
		}
	}

	@Override
	public Object pop() {
		return arr[top--];
	}

//	public void printStack() {
//		return Arrays.toString(arr);
//	}
}
