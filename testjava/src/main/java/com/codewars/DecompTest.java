package com.codewars;

import static org.junit.Assert.*;
import org.junit.Test;

public class DecompTest {

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }
    @Test
    public void test1() {
        testing(Decomp.decompose("3", "4"), "[1/2, 1/4]");
        testing(Decomp.decompose("12", "4"), "[3]");
        testing(Decomp.decompose("0", "2"), "[]");
        testing(Decomp.decompose("9", "10"), "[1/2, 1/3, 1/15]");
    }
}