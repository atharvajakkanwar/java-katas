package com.carlosbecker.fibonacci;

public interface Fibonacci {
	int innerCalc(int n);

	default int calc(int n) {
		validate(n);
		if (n == 0)
			return 0;
		if (n <= 2)
			return 1;
		return innerCalc(n);
	}

	default void validate(int n) {
		if (n < 0)
			throw new IllegalArgumentException("This class does not deal with negative numbers");
	}
}
