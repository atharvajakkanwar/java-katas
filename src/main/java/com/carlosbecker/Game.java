package com.carlosbecker;

public class Game {
	private int rolls[] = new int[21];
	private int currentRoll = 0;

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public int score() {
		int index = 0, score = 0;
		for (int frame = 0; frame < 10; frame++) {
			if (isStrike(index))
				score += 10 + strikeBonus(index++);
			else if (isSpare(index)) {
				score += 10 + spareBonus(index);
				index += 2;
			} else {
				score += sumBallsInFrame(index);
				index += 2;
			}
		}
		return score;
	}

	private boolean isStrike(int index) {
		return rolls[index] == 10;
	}

	private int sumBallsInFrame(int index) {
		return rolls[index] + rolls[index + 1];
	}

	private int spareBonus(int index) {
		return rolls[index + 2];
	}

	private int strikeBonus(int index) {
		return rolls[index + 1] + spareBonus(index);
	}

	private boolean isSpare(int index) {
		return sumBallsInFrame(index) == 10;
	}
}
