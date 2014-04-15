package com.carlosbecker.robot;


public enum Command {
	M, L, R;

	public boolean isMove() {
		return this == M;
	}

	public static boolean isValid(String command) {
		try {
			valueOf(command);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
