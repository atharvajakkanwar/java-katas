package com.carlosbecker;

import com.carlosbecker.fibonacci.*;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.stream;
import static org.junit.Assert.assertEquals;

public class FibonacciTest {
	private Fibonacci[] impls;

	@Before
	public void init() {
		impls = new Fibonacci[]{new CachedTailRecursiveFibonacci(),
				new TailRecursiveFibonacci(), new CachedFibonacciImpl(),
				new FibonacciImpl()};
	}

	@Test
	public void fib0() throws Exception {
		test(0, 0);
	}

	@Test
	public void fib1() throws Exception {
		test(1, 1);
	}

	@Test
	public void fib2() throws Exception {
		test(1, 2);
	}

	@Test
	public void test5() throws Exception {
		test(5, 5);
	}

	@Test
	public void test12() throws Exception {
		test(144, 12);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegative() throws Exception {
		test(1, -1);
	}

	@Test
	public void testSlowCalculation() throws Exception {
		test(6765, 20);
	}


	private void test(int expected, int param) {
		stream(impls).forEach((fib) -> assertEquals(expected, fib.calc(param)));
	}
}
