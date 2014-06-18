package com.carlosbecker;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.time.YearMonth;
import java.util.List;
import org.junit.Test;

public class WorkDaysTest {
	@Test
	public void workdaysOfNull() throws Exception {
		assertThat(WorkDays.of(null).isEmpty(), equalTo(true));
	}

	@Test
	public void findWorkDaysUsingYearMonth() throws Exception {
		List<Integer> days = WorkDays.of(YearMonth.of(2014, 5));
		assertFirstDayOf(days, 1);
		assertLastDayOf(days, 30);
	}

	@Test
	public void findWorkDaysWithIntegers() throws Exception {
		List<Integer> days = WorkDays.of(2014, 6);
		assertFirstDayOf(days, 2);
		assertLastDayOf(days, 30);
	}

	private void assertFirstDayOf(List<Integer> days, int expected) {
		assertThat(days.get(0), equalTo(expected));
	}

	private void assertLastDayOf(List<Integer> days, int expected) {
		assertThat(days.get(days.size() - 1), equalTo(expected));
	}

}
