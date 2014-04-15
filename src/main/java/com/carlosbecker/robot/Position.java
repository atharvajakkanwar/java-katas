package com.carlosbecker.robot;

public class Position {
	private int x, y;
	private WindRose direction;

	public Position() {
		this(0, 0, WindRose.N);
	}

	public Position(int x, int y, WindRose direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public void move(String command) {
		validate(command);
		move(Command.valueOf(command));
	}

	private void move(Command command) {
		if (command.isMove())
			moveForward();
		else
			turn(command.name());
	}

	private void turn(String side) {
		direction = direction.getSibling(Side.valueOf(side));
	}

	private void validate(String command) {
		if (!Command.isValid(command))
			throw new IllegalRobotCommandError();
	}

	private void moveForward() {
		if (direction.shouldIncY())
			incY();
		else
			incX();
	}

	private void incX() {
		x = fixWorldOverlap(x + direction.forwardChangeAmmount());
	}

	private void incY() {
		y = fixWorldOverlap(y + direction.forwardChangeAmmount());
	}

	private int fixWorldOverlap(int value) {
		if (value > Robot.WORLD_SIZE)
			return 0;
		if (value < 0)
			return Robot.WORLD_SIZE;
		return value;
	}

	@Override
	public String toString() {
		return String.format("%d%d%s", x, y, direction.name());
	}

}
