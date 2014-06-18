package com.carlosbecker;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class FizzBuzzTest {
	private static FizzBuzz fb;

	@BeforeClass
	public static void init() {
		fb = new FizzBuzz();
	}

	@Test
	public void number_is_divisible_by_3() throws Exception {
		assertEquals("fizz", fb.exec(3));
	}

	@Test
	public void number_is_divisible_by_5() throws Exception {
		assertEquals("buzz", fb.exec(5));
	}

	@Test
	public void number_is_divisible_by_both_3_and_5() throws Exception {
		assertEquals("fizzbuzz", fb.exec(15));
	}
	
	@Test
	public void number_is_divisible_by_neither_3_or_5() throws Exception {
		assertEquals("8", fb.exec(8));
	}
}
