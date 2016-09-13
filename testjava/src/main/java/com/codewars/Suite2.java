package com.codewars;

/**
 * https://www.codewars.com/kata/55ab4f980f2d576c070000f4/train/java
 */
public class Suite2 {

    public static String game(long n) {
        long result = n * n;
        if (result % 2 == 0) {
            return "[" + result / 2 + "]";
        } else {
            return "[" + result + ", 2]";
        }
    }
}