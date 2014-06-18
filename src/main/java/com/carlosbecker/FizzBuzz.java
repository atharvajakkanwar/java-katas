package com.carlosbecker;

public class FizzBuzz {

	public String exec(Integer number) {
		String str = "";
		if (number % 3 == 0)
			str += "fizz";
		if (number % 5 == 0)
			str += "buzz";
		return str.isEmpty() ? number.toString() : str;
	}
}
