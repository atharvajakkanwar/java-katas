package com.carlosbecker;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Ignore;
import org.junit.Test;

import static com.carlosbecker.ReversePolishNotation.calc;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReversePolishNotationTest {

    @Test
    public void testSimplesOperation() throws Exception {
        assertCalc("0 0 +").eq(0);
        assertCalc("0 0 0 0 0 0 +").eq(0);
    }

    @Test
    public void testInvalidExpression() throws Exception {
        assertCalc(" /").eq(0);
    }

    @Test
    public void testWithMultipleSpaces() throws Exception {
        assertCalc(" 0   1 +  ").eq(1);
    }

    @Test
    public void testOnePlusOne() throws Exception {
        assertCalc("1 1 +").eq(2);
        assertCalc("1 1 1 +").eq(3);
    }

    @Test
    public void testSubtraction() throws Exception {
        assertCalc("1 3 -").eq(2);
    }

    @Test
    public void testDivision() throws Exception {
        assertCalc("2 4 /").eq(2);
    }

    @Test
    public void testMultiply() throws Exception {
        assertCalc("2 2 *").eq(4);
    }

    @Test
    public void testNegativeNumber() throws Exception {
        assertCalc("-1 2 +").eq(1);
    }

    @Test
    @Ignore
    public void testComposedExpressions() throws Exception {
        assertCalc("1 2 + 4 * 5 + 3 -").eq(14);
    }

    private RPNAssertion assertCalc(String notation) {
        return new RPNAssertion(notation);
    }

    private class RPNAssertion {
        private int result;

        public RPNAssertion(String notation) {
            this.result = calc(notation);
        }

        public void eq(int expected) {
            assertThat(result, equalTo(expected));
        }
    }
}
