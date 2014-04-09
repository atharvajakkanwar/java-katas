package com.carlosbecker.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class CachedTailRecursiveFibonacci implements Fibonacci {
	private final Map<Integer, Integer> cache = new HashMap<>();

	@Override
	public int innerCalc(int n) {
		return calc(0, 1, n);
	}

	private int calc(int a, int b, int count) {
		if (count <= 0)
			return a;
		return cache.computeIfAbsent(count, (key) -> calc(b, a + b, count - 1));
	}
}
