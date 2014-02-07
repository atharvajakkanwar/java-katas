package com.carlosbecker;

import static com.google.common.base.CharMatcher.WHITESPACE;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

/**
 * @author carlos
 * 
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
		if (isValid(input))
			return "";
		return join(split(input));
	}

	private List<String> split(String input) {
		return splitOnLimit(splitOnSpace(input));
	}

	private List<String> splitOnLimit(List<String> list) {
		List<String> result = new ArrayList<String>();
		for (String word : list) {
			result.addAll(splitOnLimit(word));
		}
		return result;
	}

	private List<String> splitOnLimit(String word) {
		Iterable<String> splitted = Splitter.fixedLength(lineLimit).split(word);
		return Lists.newArrayList(splitted);
	}

	private List<String> splitOnSpace(String input) {
		return Splitter.on(WHITESPACE).splitToList(input);
	}

	private String join(List<String> list) {
		return Joiner.on("\\n").join(list);
	}

	private boolean isValid(String input) {
		return input == null || input.trim().isEmpty();
	}

}
