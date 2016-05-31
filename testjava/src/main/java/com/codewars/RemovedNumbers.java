package com.codewars;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.codewars.com/kata/5547cc7dcad755e480000004/train/java
 * failed
 */
public class RemovedNumbers {

    public static List<long[]> removNb(long n) {
        List<long[]> result = new ArrayList<>();
        if (n < 2) {
            return result;
        }
        long sn = (1 + n) * n / 2;
        for (long i = 1; i < n; i++) {
            if (i * (i + 1) > sn) {
                break;
            }
            for (long j = i + 1; j <= n; j++) {
                if (i * j > sn) {
                    break;
                }
                if (sn == (i * j) + i + j) {
                    long[] item = new long[2];
                    item[0] = i;
                    item[1] = j;
                    result.add(item);

                    long[] item1 = new long[2];
                    item1[0] = j;
                    item1[1] = i;
                    result.add(item1);
                }
            }
        }
        return result;
    }
}