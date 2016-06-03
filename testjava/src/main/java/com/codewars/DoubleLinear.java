package com.codewars;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * http://www.codewars.com/kata/5672682212c8ecf83e000050/train/java
 * fail
 */
class DoubleLinear {
    /**
     * clevr
     * @param n
     * @return
     */
    public static int dblLinear(int n) {
        if (n == 0) return 1;
        SortedSet<Integer> u = new TreeSet<>();
        u.add(1);
        for(int i=0; i<n; i++) {
            int x = u.first();
            u.add(x*2+1);
            u.add(x*3+1);
            u.remove(x);
        }
        return u.first();
    }
   /* public static int dblLinear(int n) {
        System.out.println("n:" + n);
        int count = 0;
        while (n > Math.pow(2, count)) {
            n -= Math.pow(2, count);
            count++;
        }
        System.out.println("n:" + n + ", count:" + count);
        return Math.max(getResult(n - 1, count), getResult(n - 2, count));
    }

    private static int getResult(int n, int count) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int t = 0x1 & n;
            System.out.print(t);
            list.add(0, t);
            n >>= 1;
        }
        int result = 1;
        for (Integer t : list) {
            if (t == 0) {
                result = getY(result);
            } else {
                result = getZ(result);
            }
        }
        return result;
    }

    public static int getY(int x) {
        return 2 * x + 1;
    }

    public static int getZ(int x) {
        return 3 * x + 1;
    }*/
}