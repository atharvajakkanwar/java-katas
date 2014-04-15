package com.carlosbecker.robot;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RobotTest {
	private Robot robot;

	@Before
	public void init() {
		robot = new Robot();
	}

	@Test
	public void initialPosition() throws Exception {
		assertEquals("00N", robot.getPosition());
	}

	@Test
	public void moveToNowhere() throws Exception {
		assertEquals("00N", robot.move(""));
	}

	@Test
	public void moveForwardNorth() throws Exception {
		assertEquals("01N", robot.move("M"));
	}

	@Test
	public void turnRight() throws Exception {
		assertEquals("00E", robot.move("R"));
	}

	@Test
	public void turnRightUntilOverlap() throws Exception {
		assertEquals("00E", robot.move("RRRRR"));
	}

	@Test
	public void turnLeft() throws Exception {
		assertEquals("00W", robot.move("L"));
	}

	@Test
	public void turnLeftUntilOverlap() throws Exception {
		assertEquals("00W", robot.move("LLLLL"));
	}

	@Test
	public void moveAndTurn() throws Exception {
		assertEquals("02W", robot.move("MML"));
	}

	@Test
	public void moveTurnAndMove() throws Exception {
		assertEquals("11E", robot.move("MRM"));
	}

	@Test
	public void complexMovementation() throws Exception {
		assertEquals("13N", robot.move("MRMLMM"));
	}

	@Test
	public void doABarrelRoll() throws Exception {
		assertEquals("00W", robot.move("MMRMMRMMRMM"));
	}

	@Test
	public void testOverlapOutOfBoundsNorth() throws Exception {
		assertEquals("01N", robot.move("MMMMMM"));
	}

	@Test
	public void testOverlapOutOfBoundsWest() throws Exception {
		assertEquals("40W", robot.move("LM"));
	}

	@Test
	public void testOverlapOutOfBoundsEast() throws Exception {
		assertEquals("10E", robot.move("RMMMMMM"));
	}

	@Test
	public void testOverlapOutOfBoundsSouth() throws Exception {
		assertEquals("04S", robot.move("LLM"));
	}

	@Test(expected = IllegalRobotCommandError.class)
	public void crashOnInvalidCommand() throws Exception {
		robot.move("MMLRST");
	}
}