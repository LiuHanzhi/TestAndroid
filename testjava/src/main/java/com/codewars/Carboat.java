package com.codewars;
/**
 * https://www.codewars.com/kata/55b4d87a3766d9873a0000d4/train/java
 * success
 */

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Carboat {

    /**
     * clever
     * @param m
     * @param n
     * @return
     */
    public static String howmuch(int m, int n) {
        List<String> solutions = IntStream.rangeClosed(Math.min(m, n), Math.max(m, n))
                .boxed()
                .filter(f -> f % 9 == 1 && f % 7 == 2)
                .map(f -> "[M: " + f + " B: " + f / 7 + " C: " + f / 9 + "]")
                .collect(toList());
        return   "[" +  String.join((""),solutions) + "]";

    }
}
/*
import java.util.ArrayList;
import java.util.List;

public class Carboat {

    public static String howmuch(int m, int n) {
        List<Bean> list = new ArrayList<>();
        int min = Math.min(m, n);
        int max = Math.max(m, n);
        int M = 0;
        int C = min / 9;
        if (9 * C + 1 < min) {
            C++;
        }
        while (9 * C + 1 <= max) {
            M = 9 * C + 1;
            if ((M - 2) % 7 == 0) {
                Bean bean = new Bean();
                bean.M = M;
                bean.B = (M - 2) / 7;
                bean.C = C;
                list.add(bean);
            }
            C++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Bean bean : list) {
            sb.append("[M: " + bean.M + " B: " + bean.B + " C: " + bean.C + "]");
        }
        sb.append("]");
        return sb.toString();
    }


    public static class Bean {
        int M;
        int B;
        int C;

        public int getM() {
            return M;
        }

        public void setM(int m) {
            M = m;
        }

        public int getB() {
            return B;
        }

        public void setB(int b) {
            B = b;
        }

        public int getC() {
            return C;
        }

        public void setC(int c) {
            C = c;
        }
    }
}*/
