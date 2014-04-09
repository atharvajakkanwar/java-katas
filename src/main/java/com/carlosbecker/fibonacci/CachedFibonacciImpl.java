package com.carlosbecker.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class CachedFibonacciImpl extends FibonacciImpl {
	private final Map<Integer, Integer> cache = new HashMap<>();

	@Override
	public int innerCalc(int n) {
		return cache.computeIfAbsent(n, (key) -> super.innerCalc(n));
	}
}
