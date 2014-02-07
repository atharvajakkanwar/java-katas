package com.carlosbecker;

import java.util.ArrayList;
import java.util.List;

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

	private String[] split(String input) {
		return splitOnLimit(splitOnSpace(input));
	}

	private String[] splitOnLimit(String[] words) {
		List<String> result = new ArrayList<String>();
		for (String word : words) {
			result.addAll(splitOnLimit(word));
		}
		return result.toArray(new String[] {});
	}

	private List<String> splitOnLimit(String word) {
		int i = 0;
		List<String> result = new ArrayList<String>();
		while (word.length() > i + lineLimit) {
			result.add(word.substring(i, i + lineLimit));
			i += lineLimit;
		}
		result.add(word.substring(i, word.length()));
		return result;
	}

	private String[] splitOnSpace(String input) {
		return input.split("\\s+");
	}

	private String join(String[] lines) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < lines.length;) {
			result.append(lines[i]);
			if (++i < lines.length)
				result.append("\\n");
		}
		return result.toString();
	}

	private boolean isValid(String input) {
		return input == null || input.trim().isEmpty();
	}

}
