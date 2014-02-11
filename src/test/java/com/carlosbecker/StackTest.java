package com.carlosbecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author carlos
 *
 */
public class StackTest {

	private Stack stack;

	@Before
	public void init() {
		stack = new Stack(5);
	}

	@Test
	public void should_be_empty() throws Exception {
		assertTrue(stack.isEmpty());
	}

	@Test(expected = Stack.Underflow.class)
	public void empty_stack_will_throw_Underflow_when_popped() throws Exception {
		stack.pop();
	}

	@Test(expected = Stack.Overflow.class)
	public void push_more_than_five_should_throw_Overflow() throws Exception {
		stack.push(1);
		stack.push(3);
		stack.push(5);
		stack.push(5);
		stack.push(6);
	}

	@Test
	public void after_push_one_item_size_should_be_1() throws Exception {
		stack.push(0);
		assertEquals(1, stack.size());
		assertFalse(stack.isEmpty());
	}

	@Test
	public void after_push_twice_size_should_be_2() throws Exception {
		stack.push(0);
		stack.push(1);
		assertEquals(2, stack.size());
		assertFalse(stack.isEmpty());
	}

	@Test
	public void after_push_twice_and_pop_once_size_should_be_1()
			throws Exception {
		stack.push(0);
		stack.push(1);
		stack.pop();
		assertEquals(1, stack.size());
		assertFalse(stack.isEmpty());
	}

	@Test
	public void push_pop_should_get_last_item() throws Exception {
		stack.push(1);
		stack.push(3);
		stack.push(2);
		assertFalse(stack.isEmpty());
		assertEquals(3, stack.size());
		assertEquals(2, stack.pop());
		assertEquals(3, stack.pop());
	}
}
