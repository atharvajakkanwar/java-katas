package com.carlosbecker.fibonacci;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TailRecursiveFibonacci implements Fibonacci {
	public int innerCalc(int n) {
		return calc(0, 1, n);
	}

	private int calc(int a, int b, int count) {
		if (count <= 0)
			return a;
		return calc(b, a + b, count - 1);
	}
}
