package com.carlosbecker;

import java.util.Stack;
import java.util.function.BiFunction;

import static java.util.Arrays.stream;

public class ReversePolishNotation {
    public static int calc(String notation) {
        if (notation.split(" ").length < 3)
            return 0;
        return calcValidNotation(notation.trim().replaceAll("( )+", " "));
    }

    private static int calcValidNotation(String notation) {
        Stack<Integer> numbers = new Stack<>();
        stream(notation.split(" "))
                .forEach(x -> calc(numbers, x));
        return numbers.pop();
    }

    private static void calc(Stack<Integer> numbers, String number) {
        switch (number) {
            case ("+"):
                calc(numbers, (x, y) -> x + y);
                break;
            case ("-"):
                calc(numbers, (x, y) -> x - y);
                break;
            case ("*"):
                calc(numbers, (x, y) -> x * y);
                break;
            case ("/"):
                calc(numbers, (x, y) -> x / y);
                break;
            default:
                numbers.push(Integer.parseInt(number));
        }
    }

    private static void calc(Stack<Integer> numbers, BiFunction<Integer, Integer, Integer> fn) {
        while (numbers.size() > 1)
            numbers.push(fn.apply(numbers.pop(), numbers.pop()));
    }
}
