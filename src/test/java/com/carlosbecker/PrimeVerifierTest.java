package com.carlosbecker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimeVerifierTest {
	private PrimeVerifier prime;

	@Before
	public void init() {
		prime = new PrimeVerifier();
	}

	@Test
	public void test_negative() throws Exception {
		assertFalse(prime.is(-1));
	}

	@Test
	public void test_zero() throws Exception {
		assertFalse(prime.is(0));
	}

	@Test
	public void test_one() throws Exception {
		assertFalse(prime.is(1));
	}

	@Test
	public void test_two() throws Exception {
		assertTrue(prime.is(2));
	}

	@Test
	public void test_three() throws Exception {
		assertTrue(prime.is(3));
	}

	@Test
	public void test_five() throws Exception {
		assertTrue(prime.is(5));
	}

	@Test
	public void test_six() throws Exception {
		assertFalse(prime.is(6));
	}
}
