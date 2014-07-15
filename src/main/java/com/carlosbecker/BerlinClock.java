package com.carlosbecker;

import static java.util.Arrays.stream;

import java.util.List;
import java.util.stream.Collectors;

public class BerlinClock {

	public String seconds(int seconds) {
		return seconds % 2 == 0 ? "Y" : "O";
	}

	public String topHours(int hours) {
		return lighRedLamps(numberOfLamps(hours));
	}

	public String bottomHours(int hours) {
		return lighRedLamps(hours % 5);
	}

	public String topMinutes(int count) {
		return ligthYellowLamps(numberOfLamps(count)).replaceAll("YYY", "YYR");
	}

	public String bottomMinutes(int count) {
		int lamps = count % 5;
		return repeat("Y", lamps) + repeat("O", 4 - lamps);
	}

	private String ligthYellowLamps(int count) {
		return repeat("Y", count) + repeat("O", 11 - count);
	}

	private int numberOfLamps(int hours) {
		return (hours - (hours % 5)) / 5;
	}

	private String lighRedLamps(int count) {
		return repeat("R", count) + repeat("O", 4 - count);
	}

	private String repeat(String character, int times) {
		return new String(new char[times]).replace("\0", character);
	}

	public String[] time(String time) {
		List<Integer> times = stream(time.split(":"))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		return new String[] {
				seconds(times.get(2)),
				topHours(times.get(0)),
				bottomHours(times.get(0)),
				topMinutes(times.get(1)),
				bottomMinutes(times.get(1))
		};
	}
}
