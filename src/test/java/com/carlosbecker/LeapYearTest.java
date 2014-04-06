package com.carlosbecker;

import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LeapYearTest {
	private LeapYearVerifier verifier;

	@Before
	public void init() {
		verifier = new LeapYearVerifier();
	}

	@Test
	public void testInvalidYear() throws Exception {
		testNonLeap(-1);
	}

	@Test
	public void testLeapYears() throws Exception {
		for (int year : asList(1804, 1956, 2012, 2080, 2084)) {
			testLeap(year);
		}
	}

	@Test
	public void testNonLeapYear() throws Exception {
		for (int year : asList(1806, 1957, 2014, 2019, 2023)) {
			testNonLeap(year);
		}
	}

	private void testNonLeap(int year) {
		test(year, false);
	}

	private void testLeap(int year) {
		test(year, true);
	}

	private void test(int year, boolean leap) {
		assertThat("Year " + year, verifier.isLeapYear(year), is(leap));
	}
}
