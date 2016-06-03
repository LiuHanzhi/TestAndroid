package com.codewars;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.codewars.com/kata/54eb33e5bc1a25440d000891/train/java
 * failed
 */
public class Decompose {

    long total;
    long count;

    public String decompose(long n) {
        List<Long> list = new ArrayList<>();
        total = (long) Math.pow(n, 2);
        count = n - 1;
        while (total > 0) {
            System.out.println("count:" + count + ", total:" + total);
            long powN = (int) Math.pow(count, 2);
            if (total >= powN) {
                if (list.contains(count)) {
                    if (shouldContinue(list)) {
                        continue;
                    } else {
                        break;
                    }
                } else {
                    total -= powN;
                    list.add(0, count);
                    count = (long) (Math.sqrt(total));
                }
            } else {
                count--;
                if (count <= 0) {
                    break;
                }
            }
        }
        if (total == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(list.get(i));
                if (i != list.size() - 1) {
                    stringBuilder.append(" ");
                }
            }
            return stringBuilder.toString();
        } else {
            return null;
        }
    }

    public boolean shouldContinue(List<Long> list) {
        if (list.size() > 2) {
            long first = list.get(0);
            total += Math.pow(first, 2);
            list.remove(0);
            first = list.get(0);
            total += Math.pow(first, 2);
            list.remove(0);
            count = list.get(0) - 1;
            return true;
        }
        return false;
    }
}