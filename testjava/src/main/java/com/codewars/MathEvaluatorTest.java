package com.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathEvaluatorTest {
    @Test
    public void testAddition() {
        assertEquals(new MathEvaluator().calculate("1+1"), 2d, 0.01);
    }

    @Test
    public void testSubtraction() {
        assertEquals(new MathEvaluator().calculate("1 - 1"), 0d, 0.01);
    }

    @Test
    public void testMultiplication() {
        assertEquals(new MathEvaluator().calculate("1* 1"), 1d, 0.01);
    }

    @Test
    public void testDivision() {
        assertEquals(new MathEvaluator().calculate("1 /1"), 1d, 0.01);
    }

    @Test
    public void testNegative() {
        assertEquals(new MathEvaluator().calculate("-123"), -123d, 0.01);
    }

    @Test
    public void testLiteral() {
        assertEquals(new MathEvaluator().calculate("123"), 123d, 0.01);
    }

    @Test
    public void testExpression() {
        assertEquals(new MathEvaluator().calculate("2 /2+3 * 4.75- -6"), 21.25, 0.01);
    }

    @Test
    public void testSimple() {
        assertEquals(new MathEvaluator().calculate("12* 123"), 1476d, 0.01);
    }

    @Test
    public void testComplex() {
        assertEquals(new MathEvaluator().calculate("2 / (2 + 3) * 4.33 - -6"), 7.732, 0.01);
    }

    @Test
    public void testComplex2() {
        assertEquals(new MathEvaluator().calculate("12* 123/-(-5 + 2)"), 492.0, 0.01);
    }

    @Test
    public void testComplex1() {
        assertEquals(new MathEvaluator().calculate("(123.45*(678.90 / (-2.5+ 11.5)-(((80 -(19))) *33.25)) / 20) - (123.45*(678.90 / (-2.5+ 11.5)-(((80 -(19))) *33.25)) / 20) + (13 - 2)/ -(-11) "), 1.0, 0.01);
    }

    @Test
    public void testComplex3() {
        assertEquals(new MathEvaluator().calculate("(13 - 2)/ -(-11) "), 1.0, 0.01);
    }

    @Test
    public void testComplex5() {
        assertEquals(new MathEvaluator().calculate("123.45*(678.90 / (-2.5+ 11.5)-(80 -19) *33.25) / 20 + 11"), -12042.760875, 0.01);
    }

    @Test
    public void testComplex6() {
        assertEquals(new MathEvaluator().calculate("1-3+4"), 2, 0.01);
    }


}