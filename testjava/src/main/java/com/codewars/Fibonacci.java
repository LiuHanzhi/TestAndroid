package com.codewars;

import java.math.BigInteger;

/**
 * http://www.codewars.com/kata/53d40c1e2f13e331fc000c26/train/java
 */
public class Fibonacci {

    public static BigInteger fib(BigInteger n) {
        System.out.println("n:" + n.toString());
        if (n.intValue() == 0) {
            return BigInteger.valueOf(0);
        }
        if (n.intValue() == 1) {
            return BigInteger.valueOf(1);
        }
        //return fib(n.add(BigInteger.valueOf(-1))).add(fib(n.add(BigInteger.valueOf(-2))));
        return BigInteger.valueOf((long) (1/Math.sqrt(5)*
                (Math.pow(1+Math.sqrt(5)/2,n.longValue()) -
                        Math.pow(1-Math.sqrt(5)/2,n.longValue()))));
    }

}