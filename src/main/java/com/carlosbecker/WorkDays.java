package com.carlosbecker;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.util.stream.Collectors.toList;

import java.time.DayOfWeek;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.IntStream;

public class WorkDays {
	private static final EnumSet<DayOfWeek> weekend = EnumSet.of(SUNDAY,
			SATURDAY);

	public static List<Integer> of(YearMonth month) {
		if (month == null || month.getMonth() == null)
			return new ArrayList<>();
		return IntStream
				.rangeClosed(1, month.lengthOfMonth())
				.filter(day -> filter(month, day))
				.boxed()
				.collect(toList());
	}

	public static List<Integer> of(int year, int month) {
		return of(YearMonth.of(year, month));
	}

	private static boolean filter(YearMonth month, int day) {
		return !weekend.contains(month.atDay(day).getDayOfWeek());
	}
}
