package com.carlosbecker;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

/**
 * @author carlos
 */
public class WordWrapper {

	private int lineLimit;

	public WordWrapper(int lineLimit) {
		this.lineLimit = lineLimit;
	}

	/**
	 * @param input
	 * @return
	 */
	public String wrap(String input) {
		if (!isValid(input))
			return "";
		return asList(input.split(" "))
				.stream()
				.map((word) -> asList(word.split("(?<=\\G.{" + lineLimit + "})")))
				.reduce(new ArrayList<>(), (list, words) -> {
					list.addAll(words);
					return list;
				})
				.stream()
				.collect(joining("\\n"));
	}

	private boolean isValid(String input) {
		return input != null && !input.trim().isEmpty();
	}
}
