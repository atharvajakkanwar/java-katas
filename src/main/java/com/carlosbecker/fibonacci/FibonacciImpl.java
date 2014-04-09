package com.carlosbecker.fibonacci;

public class FibonacciImpl implements Fibonacci {
	@Override
	public int innerCalc(int n) {
		return calc(n - 2) + calc(n - 1);
	}
}
