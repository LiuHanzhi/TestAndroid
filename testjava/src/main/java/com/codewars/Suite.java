package com.codewars;

/**
 * http://www.codewars.com/kata/55a29405bc7d2efaff00007c/train/java
 * success
 */
public class Suite {

    public static double going(int n) {
        System.out.println("n:" + n);
        double sum = doFactorial(n);
        System.out.println("sum:" + sum);
//        return (int) (sum * 1000000) * 1.0 / 1000000;
        return Math.floor(sum * 1000000) / 1000000d; //better solution
    }

    public static double doFactorial(int n) {
        if (n == 1) {
            return 1;
        }
        return 1 + doFactorial(n - 1) * 1.0f / n;
    }
}