package com.carlosbecker;

/**
 * @author carlos
 * 
 */
public class Prime {

	public static boolean result(int number) {
		if (number <= 1)
			return false;
		return isPrime(number);
	}

	private static boolean isPrime(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}
}
