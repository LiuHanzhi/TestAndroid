package com.codewars;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * https://www.codewars.com/kata/554f76dca89983cc400000bb/train/java
 * failed
 */
public class Dioph {

    public static String solEquaStr(long n) {
        System.out.println("n:" + n);
        TreeSet<KVBean> set = new TreeSet<>();
        for (long y = n / 4; y >= 0;y--) {
            double x = Math.sqrt(n + 4 * Math.pow(y, 2));
            if (x % 1 == 0) {
                KVBean kvBean = new KVBean();
                kvBean.setX((long) x);
                kvBean.setY(y);
                set.add(kvBean);
                //y = y - 1;
            } /*else {
                long temp = (long) (Math.sqrt(Math.pow((long) (x), 2) - n) / 2);
                y = Math.min(y - 1, temp);
            }*/
        }
        if (set.size() == 0) {
            return "[]";
        }
        Iterator<KVBean> iterator = set.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (iterator.hasNext()) {
            KVBean kvBean = iterator.next();
            stringBuilder.append("[" + kvBean.getX() + ", " + kvBean.getY() + "]");
            if (iterator.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static class KVBean implements Comparable {
        long x;
        long y;

        public long getX() {
            return x;
        }

        public void setX(long x) {
            this.x = x;
        }

        public long getY() {
            return y;
        }

        public void setY(long y) {
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof KVBean) {
                return (int) (((KVBean) o).getX() - getX());
            }
            return 0;
        }
    }

}