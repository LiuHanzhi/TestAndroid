package com.codewars;

/**
 * https://www.codewars.com/kata/556eed2836b302917b0000a3/train/java
 * success
 */
public class SystemOfEq {

    public static int Solution(int n, int m) {
        int count = 0;
        for (int b = 0; b <= Math.sqrt(m); b++) {
            int a = (int) (m - Math.pow(b, 2));
            if (Math.pow(a, 2) + b == n) {
                count++;
            }
        }
        return count;
    }
}