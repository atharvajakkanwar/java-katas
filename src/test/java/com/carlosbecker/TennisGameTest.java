package com.carlosbecker;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TennisGameTest {

    private TennisGame game;

    @Before
    public void init() {
        game = new TennisGame();
    }

    @Test
    public void descriptionIsLoveWhen0x0() throws Exception {
        assertThat(game.getScore(), equalTo("love, love"));
    }

    @Test
    public void scoreIsFifteenWhen1x0() throws Exception {
        player(1).scores();
        assertGameScoreEqTo("fifteen, love");
    }

    @Test
    public void when2xSomethingScoreShouldBeThirty() throws Exception {
        player(2).scores(2);
        assertGameScoreEqTo("love, thirty");
    }

    @Test
    public void when3xSomethingScoreShouldBeForty() throws Exception {
        player(1).scores(3);
        player(2).scores(2);
        assertGameScoreEqTo("forty, thirty");
    }

    @Test
    public void when4xSomethingIsAdvantage() throws Exception {
        player(1).scores(4);
        player(2).scores(3);
        assertGameScoreEqTo("advantage Player1");
    }

    @Test
    public void testDeuce3() throws Exception {
        player(1).scores(3);
        player(2).scores(3);
        assertGameScoreEqTo("deuce");
    }

    @Test
    public void testDeuceMoreThan3() throws Exception {
        player(1).scores(4);
        player(2).scores(4);
        assertGameScoreEqTo("deuce");
    }

    @Test
    public void testPlayerOneWonBasic() throws Exception {
        player(1).scores(4);
        player(2).scores(2);
        assertGameScoreEqTo("Player1 won");
    }

    @Test
    public void testPlayerOneWonComplex() throws Exception {
        player(1).scores(6);
        player(2).scores(4);
        assertGameScoreEqTo("Player1 won");
    }

    @Test
    public void testPlayer2Won() throws Exception {
        player(1).scores(3);
        player(2).scores(5);
        assertGameScoreEqTo("Player2 won");
    }

    private void assertGameScoreEqTo(String score) {
        assertThat(game.getScore(), equalTo(score));
    }

    private PlayerScoreBuilder player(int i) {
        return new PlayerScoreBuilder(i);
    }

    private class PlayerScoreBuilder {
        private int player;

        public PlayerScoreBuilder(int player) {
            this.player = player;
        }

        public void scores() {
            scores(1);
        }

        public void scores(int balls) {
            rangeClosed(1, balls).forEach(i -> game.playerScores(player));
        }
    }
}
