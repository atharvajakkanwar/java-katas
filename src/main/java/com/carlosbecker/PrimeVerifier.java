package com.carlosbecker;

/**
 * @author carlos
 */
public class PrimeVerifier {
	public boolean is(int number) {
		return number > 1 && isPrime(number);
	}

	private boolean isPrime(int number) {
		for (int i = 2; i < number; i++)
			if (number % i == 0)
				return false;
		return true;
	}
}
