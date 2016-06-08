package com.codewars;

import static org.junit.Assert.*;

import org.junit.Test;


public class DecomposeTest {

    @Test
    public void test1() {
        Decompose d = new Decompose();
        long n = 11;
        assertEquals("1 2 4 10", d.decompose(n));
        assertEquals("1 3 5 8 49", d.decompose(50));
        assertEquals(null, d.decompose(4));
        assertEquals("1 2 3 7 9",d.decompose(12));
        assertEquals("2 5 8 34 624",d.decompose(625));
    }
}

