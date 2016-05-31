package com.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractsTest {
    @Test
    public void test_fractions() throws Exception {
        long[][] lst;
        lst = new long[][]{{1, 2}, {1, 3}, {1, 4}};
        assertEquals("(6,12)(4,12)(3,12)", Fracts.convertFrac(lst));
    }
    @Test
    public void test_fractions2() throws Exception {
        long[][] lst;
        lst = new long[][]{{1, 2}, {1, 3}, {1, 4},{77,130},{84,131},{3,4}};
        assertEquals("([20174,34060)(21840,34060)(25545,34060)", Fracts.convertFrac(lst));
    }
}
