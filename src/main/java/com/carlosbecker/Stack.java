package com.carlosbecker;

public class Stack {
	private Integer[] elements;
	private int size;

	public Stack(int capacity) {
		this.size = 0;
		this.elements = new Integer[capacity];
	}

	public int pop() {
		if (isEmpty())
			throw new Underflow();
		int elem = elements[--size];
		elements[size] = null;
		return elem;
	}

	public void push(int elem) {
		if (size + 1 == elements.length)
			throw new Overflow();
		elements[size++] = elem;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public class Underflow extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}

	public class Overflow extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}
}
