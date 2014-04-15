package com.carlosbecker;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {
	private Fibonacci fib;

	@Before
	public void init() {
		fib = new Fibonacci();
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

	@Test(timeout = 100)
	public void testSlowCalculation() throws Exception {
		fib.calc(1000);
	}


	private void test(long expected, long param) {
		assertEquals(expected, fib.calc(param));
	}
}
