package com.carlosbecker;

import static com.carlosbecker.PrimeFactors.generate;
import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class PrimeFactorsTest {
	@Test
	public void testOne() throws Exception {
		assertThat(generate(1), is(asList()));
	}

	@Test
	public void testTwo() throws Exception {
		assertThat(generate(2), is(asList(2)));
	}

	@Test
	public void testThree() throws Exception {
		assertThat(generate(3), is(asList(3)));
	}

	@Test
	public void testFour() throws Exception {
		assertThat(generate(4), is(asList(2, 2)));
	}

	@Test
	public void testSix() throws Exception {
		assertThat(generate(6), is(asList(2, 3)));
	}
	
	@Test
	public void testEight() throws Exception {
		assertThat(generate(8), is(asList(2, 2, 2)));
	}
	
	@Test
	public void testNine() throws Exception {
		assertThat(generate(9), is(asList(3, 3)));
	}
}