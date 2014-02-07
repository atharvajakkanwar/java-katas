package com.carlosbecker;

/**
 * @author carlos
 * 
 */
public class FizzBuzz {

	/**
	 * @param number
	 * @return
	 */
	public String exec(Integer number) {
		String str = "";
		if (number % 3 == 0)
			str += "fizz";
		if (number % 5 == 0)
			str += "buzz";
		return str.isEmpty() ? number.toString() : str;
	}

}
