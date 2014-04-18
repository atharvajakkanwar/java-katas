package com.carlosbecker;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AnagramTest {
	private Anagram anagrams;

	@Test
	public void emptyInput() throws Exception {
		anagrams = new Anagram(new ArrayList<>());
		assertThat(anagrams.of("").isEmpty(), is(true));
	}

	@Test
	public void nullInput() throws Exception {
		anagrams = new Anagram(new ArrayList<>());
		assertThat(anagrams.of(null).isEmpty(), is(true));
	}

	@Test
	public void twoLetterInput() throws Exception {
		anagrams = new Anagram(asList("no", "on", "as", "ops"));
		final List<String> result = anagrams.of("no");
		assertThat(result.isEmpty(), is(false));
		assertThat(result.size(), is(1));
		assertThat(result.get(0), is("on"));
	}

	@Test
	public void threeLetterInput() throws Exception {
		anagrams = new Anagram(asList("has", "ash", "had"));
		final List<String> result = anagrams.of("has");
		assertThat(result.isEmpty(), is(false));
		assertThat(result.size(), is(1));
		assertThat(result.get(0), is("ash"));
	}

	@Test
	public void fourLettersInput() throws Exception {
		anagrams = new Anagram(asList("cool", "loco", "look"));
		final List<String> result = anagrams.of("cool");
		assertThat(result.isEmpty(), is(false));
		assertThat(result.size(), is(1));
		assertThat(result.get(0), is("loco"));
	}

	@Test
	public void realInput() throws Exception {
		createFromRealInput();
		final List<String> result = anagrams.of("arrest");
		assertThat(result.size(), is(6));
	}

	private void createFromRealInput() throws URISyntaxException, IOException {
		final Path path = Paths.get(getClass().getResource("wordlist.txt")
				.toURI());
		anagrams = new Anagram(path, ISO_8859_1);
	}
}