package com.carlosbecker;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {
	private Game g;

	@Before
	public void init() {
		g = new Game();
	}

	private void rollMany(int n, int pins) {
		IntStream.range(0, n).boxed().forEachOrdered(i -> g.roll(pins));
	}

	private void rollSpare() {
		g.roll(5);
		g.roll(5);
	}

	private void rollStrike() {
		g.roll(10);
	}

	private void assertScoreEq(int to) {
		assertThat(g.score(), equalTo(to));
	}

	@Test
	public void gutterGame() throws Exception {
		rollMany(20, 0);
		assertScoreEq(0);
	}

	@Test
	public void allOnes() throws Exception {
		rollMany(20, 1);
		assertScoreEq(20);
	}

	@Test
	public void oneSpare() throws Exception {
		rollSpare();
		g.roll(3);
		rollMany(17, 0);
		assertScoreEq(16);
	}

	@Test
	public void oneStrike() throws Exception {
		rollStrike();
		g.roll(3);
		g.roll(4);
		rollMany(16, 0);
		assertScoreEq(24);
	}

	@Test
	public void perfectGame() throws Exception {
		rollMany(20, 10);
		assertScoreEq(300);
	}
}
