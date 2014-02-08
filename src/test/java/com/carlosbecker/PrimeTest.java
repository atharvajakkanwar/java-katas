package com.carlosbecker;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author carlos
 * 
 */
public class PrimeTest {
	@Test
	public void test_negative() throws Exception {
		assertFalse(Prime.result(-1));
	}

	@Test
	public void test_one() throws Exception {
		assertFalse(Prime.result(1));
	}
	
	@Test
	public void test_two() throws Exception {
		assertTrue(Prime.result(2));
	}
	
	@Test
	public void test_three() throws Exception {
		assertTrue(Prime.result(3));
	}
	
	@Test
	public void test_five() throws Exception {
		assertTrue(Prime.result(5));
	}
	
	@Test
	public void test_six() throws Exception {
		assertFalse(Prime.result(6));
	}
}
