package com.carlosbecker.robot;

import static java.util.Arrays.stream;

public class Robot {
	public static final int WORLD_SIZE = 4;
	private Position position = new Position();

	public String move(String commands) {
		if (commands != null && !commands.trim().isEmpty())
			stream(commands.split(""))
				.forEach(command -> position.move(command));
		return getPosition();
	}

	public String getPosition() {
		return position.toString();
	}
}
