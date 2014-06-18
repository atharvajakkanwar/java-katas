package com.carlosbecker;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class WordWrapper {

	private String limitRegex;

	public WordWrapper(int lineLimit) {
		this.limitRegex = "(?<=\\G.{" + lineLimit + "})";
	}

	public String wrap(String input) {
		if (!isValid(input))
			return "";
		return stream(input.split(" "))
				.map((word) -> asList(word.split(limitRegex)))
				.reduce(new ArrayList<>(), (list, words) -> {
					list.addAll(words);
					return list;
				}).stream()
				.collect(joining("\\n"));
	}

	private boolean isValid(String input) {
		return input != null && !input.trim().isEmpty();
	}
}
