package com.codewars;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Fracts {
    /**
     * http://www.codewars.com/kata/54d7660d2daf68c619000d95/train/java
     * failed
     */
    public static String convertFrac(long[][] lst) {
        Set<Long> integerSet = new HashSet<>();
        for (int i = 0; i < lst.length; i++) {
            for (int j = 0; j < lst[0].length; j++) {
                System.out.println(lst[i][j]);
                integerSet.add(lst[i][j]);
            }
        }
        Iterator<Long> iterator = integerSet.iterator();
        long m = iterator.next();
        long n = iterator.next();
        long minMutiple = minMutiple(m, n);
        while (iterator.hasNext()) {
            minMutiple = minMutiple(minMutiple, iterator.next());
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < lst.length; i++) {
            long x = lst[i][0];
            long y = lst[i][1];
            stringBuffer.append("(" + minMutiple * x / y + "," + minMutiple + ")");
        }
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        int a = 77, b = 130, c = 131, d = 84;
        long mut = minMutiple(a, b);
        mut = minMutiple(mut, c);
        mut = minMutiple(mut, d);
        System.out.print("mut:" + mut);
    }

    /**
     * 最大公约数
     *
     * @param m
     * @param n
     * @return
     */
    public static long maxDivisor(long m, long n) {
        if (m < n) {
            long temp = n;
            n = m;
            m = temp;
        }
        if (m % n == 0) {
            return n;
        }
        return maxDivisor(n, m % n);
    }

    /**
     * 最小公倍数
     *
     * @param m
     * @param n
     * @return
     */
    public static long minMutiple(long m, long n) {
        return m * n / maxDivisor(m, n);
    }

}