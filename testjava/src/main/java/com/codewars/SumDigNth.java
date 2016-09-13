package com.codewars;

/**
 * https://www.codewars.com/kata/55ffb44050558fdb200000a4/train/java
 */
public class SumDigNth {

    public static long sumDigNthTerm(long initval, long[] patternl, int nthterm) {
        long pSum = 0;
        for (int i = 0; i < patternl.length; i++) {
            pSum += patternl[i];
        }
        nthterm -= 1;
        long delta = (nthterm / patternl.length) * pSum;
        for (int i = 0; i < nthterm % patternl.length; i++) {
            delta += patternl[i];
        }

        long desc = initval + delta;
        String s = String.valueOf(desc);
        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            int ii = Integer.parseInt(String.valueOf(s.charAt(i)));
            result += ii;
        }
        return result;
    }
}