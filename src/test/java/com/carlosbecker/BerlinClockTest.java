package com.carlosbecker;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BerlinClockTest {
	private BerlinClock clock;

	@Before
	public void init() {
		clock = new BerlinClock();
	}

	@Test
	public void yellowLampShouldBlinkEveryTwoSeconds() throws Exception {
		assertThat(clock.seconds(0), equalTo("Y"));
		assertThat(clock.seconds(1), equalTo("O"));
		assertThat(clock.seconds(14), equalTo("Y"));
		assertThat(clock.seconds(59), equalTo("O"));
	}

	@Test
	public void topHoursShouldHaveFourLamps() throws Exception {
		assertThat(clock.topHours(7).length(), equalTo(4));
	}

	@Test
	public void shouldLigthARedLampEveryFiveHours() throws Exception {
		assertThat(clock.topHours(0), equalTo("OOOO"));
		assertThat(clock.topHours(13), equalTo("RROO"));
		assertThat(clock.topHours(23), equalTo("RRRR"));
		assertThat(clock.topHours(24), equalTo("RRRR"));
	}

	@Test
	public void bottonHoursShouldHaveFourLamps() throws Exception {
		assertThat(clock.bottomHours(5).length(), equalTo(4));
	}

	@Test
	public void ligthARedLampForEveryHourLeftFromTopHours() throws Exception {
		assertThat(clock.bottomHours(0), equalTo("OOOO"));
		assertThat(clock.bottomHours(13), equalTo("RRRO"));
		assertThat(clock.bottomHours(23), equalTo("RRRO"));
		assertThat(clock.bottomHours(24), equalTo("RRRR"));
	}

	@Test
	public void topMinutesShouldHave11Lamps() throws Exception {
		assertThat(clock.topMinutes(34).length(), equalTo(11));
	}

	@Test
	public void thirdLampShouldIndicateFirstQuarter() throws Exception {
		assertThat(clock.topMinutes(32).charAt(2), equalTo('R'));
	}

	@Test
	public void sixthLampShouldIndicateFirstQuarter() throws Exception {
		assertThat(clock.topMinutes(32).charAt(5), equalTo('R'));
	}

	@Test
	public void ninthLampShouldIndicateFirstQuarter() throws Exception {
		assertThat(clock.topMinutes(32).charAt(8), equalTo('O'));
	}

	@Test
	public void lightAYellowLampForEvery5MinutesUnlessItsFirstQuarterHalfOrLastQuarter()
			throws Exception {
		assertThat(clock.topMinutes(0), equalTo("OOOOOOOOOOO"));
		assertThat(clock.topMinutes(17), equalTo("YYROOOOOOOO"));
		assertThat(clock.topMinutes(59), equalTo("YYRYYRYYRYY"));
	}

	@Test
	public void bottomMinutesShouldHave4Lamps() throws Exception {
		assertThat(clock.bottomMinutes(1).length(), equalTo(4));
	}

	@Test
	public void ligthAYellowLampForEveryMinuteLeftFromTopMinutes()
			throws Exception {
		assertThat(clock.bottomMinutes(0), equalTo("OOOO"));
		assertThat(clock.bottomMinutes(17), equalTo("YYOO"));
		assertThat(clock.bottomMinutes(59), equalTo("YYYY"));
	}

	@Test
	public void resultIsA5ElementsArray() throws Exception {
		assertThat(clock.time("12:12:12").length, equalTo(5));
	}

	@Test
	public void resultIsCorrect() throws Exception {
		String[] expected = new String[] {
				"Y",
				"RRRO",
				"ROOO",
				"YYRYYRYOOOO",
				"YYOO"
		};
		assertThat(clock.time("16:37:16"), equalTo(expected));
	}
}
