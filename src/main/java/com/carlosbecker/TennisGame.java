package com.carlosbecker;

import static java.lang.String.format;

public class TennisGame {
    private static final String[] SCORE_DESCRIPTIONS = new String[]{"love", "fifteen", "thirty", "forty"};

    private int[] scores = new int[]{0, 0};

    public void playerScores(int player) {
        scores[--player] = scores[player] + 1;
    }

    public String getScore() {
        int score1 = scores[0];
        int score2 = scores[1];
        if (score1 >= 3 || score2 >= 3) {
            if (hasWinner(score1, score2))
                return format("%s won", getLeaderPlayer());
            if (score1 == score2)
                return "deuce";
            if (hasAdvantage(score1, score2))
                return format("advantage %s", getLeaderPlayer());
        }
        return format("%s, %s", SCORE_DESCRIPTIONS[score1], SCORE_DESCRIPTIONS[score2]);
    }

    private boolean hasAdvantage(int score1, int score2) {
        return score1 >= 3 && score2 >= 3;
    }

    private boolean hasWinner(int score1, int score2) {
        return Math.abs(score1 - score2) >= 2;
    }

    private String getLeaderPlayer() {
        return format("Player%1d", scores[0] > scores[1] ? 1 : 2);
    }
}
