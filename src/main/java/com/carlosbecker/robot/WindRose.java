package com.carlosbecker.robot;

public enum WindRose {
	N, E, S, W;

	public WindRose getSibling(Side side) {
		if (side == Side.L)
			return leftSibling();
		return rightSibling();
	}

	public int forwardChangeAmmount() {
		return (this == N || this == E) ? 1 : -1;
	}

	public boolean shouldIncY() {
		return this == N || this == S;
	}

	private WindRose leftSibling() {
		int pos = ordinal() - 1;
		return values()[pos < 0 ? 3 : pos];
	}

	private WindRose rightSibling() {
		int pos = ordinal() + 1;
		return values()[pos > 3 ? 0 : pos];
	}
}
