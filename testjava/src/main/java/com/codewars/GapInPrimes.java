package com.codewars;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.LongStream;

/**
 * http://www.codewars.com/kata/561e9c843a2ef5a40c0000a4/train/java
 * success
 */
class GapInPrimes {

    /**
     * clever
     * @param g
     * @param m
     * @param n
     * @return
     */
    public static long[] gap(long g, long m, long n) {
        return LongStream.
                iterate(m % 2 == 0 ? m + 1 : m, l -> l + 2).limit((n - m) / 2).filter(l -> BigInteger.valueOf(l).isProbablePrime(5) && BigInteger.valueOf(l + g).isProbablePrime(5)).filter(l -> {
            return LongStream.iterate(l + 2, c -> c + 2).limit((g - 2) / 2).parallel().filter(c -> BigInteger.valueOf(c).isProbablePrime(5)).mapToObj(c -> false).findAny().orElse(true);
        }).mapToObj(l -> new long[]{l, l + g}).findFirst().orElse(null);
    }
    /*public static long[] gap(int g, long m, long n) {
        System.out.println("g:" + g + ",m:" + m + ",n:" + n);
        long[] result = new long[2];
        for (long i = m; i <= n; ) {
            boolean isPrime = isPrime(i);
            if (isPrime) {
                if (i + g < n) {
                    isPrime = isPrime(i + g);
                    if (isPrime) {
                        for (long j = i + 1; j < i + g; j++) {
                            isPrime = isPrime(j);
                            if (isPrime) {
                                break;
                            }
                        }
                        if (!isPrime) {
                            result[0] = i;
                            result[1] = i + g;
                            System.out.println("[" + result[0] + "," + result[1] + "]");
                            System.out.println("      ");
                            return result;
                        }
                    }
                } else {
                    return null;
                }

            }
            i++;
        }
        return null;
    }*/

    private static boolean isPrime(long src) {
        for (int i = 2; i <= Math.sqrt(src); i++) {
            if (src % i == 0) {
                return false;
            }
        }
        return true;
    }
}