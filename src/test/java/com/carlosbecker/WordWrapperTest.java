package com.carlosbecker;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class WordWrapperTest {
	private static WordWrapper wrapper;

	@BeforeClass
	public static void init() {
		wrapper = new WordWrapper(5);
	}

	@Test
	public void null_input() throws Exception {
		assertEquals("", wrapper.wrap(null));
	}
	
	@Test
	public void empty_input() throws Exception {
		assertEquals("", wrapper.wrap(""));
	}
	
	@Test
	public void input_spaces() throws Exception {
		assertEquals("", wrapper.wrap("   "));
	}
	
	@Test
	public void five_chars_input() throws Exception {
		assertEquals("carla", wrapper.wrap("carla"));
	}
	
	@Test
	public void with_space() throws Exception {
		assertEquals("ma\\noe", wrapper.wrap("ma oe"));
	}
	
	@Test
	public void six_chars_input() throws Exception {
		assertEquals("carlo\\ns", wrapper.wrap("carlos"));
	}
	
	@Test
	public void long_word() throws Exception {
		assertEquals("ticar\\nacati\\nca", wrapper.wrap("ticaracatica"));
	}
	
	@Test
	public void long_input_with_spaces() throws Exception {
		assertEquals("ma\\nvem\\npra\\nca\\nvai\\npra\\nla\\nmaooe\\nee", wrapper.wrap("ma vem pra ca vai pra la maooeee"));
	}
}
