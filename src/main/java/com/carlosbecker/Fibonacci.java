package com.carlosbecker;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	private static Map<Long, Long> memo = new HashMap<>();
	static {
		memo.put(0L, 0L);
		memo.put(1L, 1L);
	}

	public long calc(long n) {
		validate(n);
		return memo.computeIfAbsent(n, (key) -> calc(n - 1) + calc(n - 2));
	}

	private void validate(long n) {
		if (n < 0)
			throw new IllegalArgumentException("Negative params are invalid.");
	}
}
