package com.codewars;


import java.util.ArrayList;

/**
 * http://www.codewars.com/kata/54f8693ea58bce689100065f/train/java
 */
class Decomp {

    public static String decompose(String nrStr, String drStr) {
        System.out.println("nr:" + nrStr + ",dr:" + drStr);
        long nr = Long.parseLong(nrStr);
        if (nr == 0) {
            return "[]";
        }
        long dr = Long.parseLong(drStr);

        if (nr > dr) {
            return "[" + nr / dr + "]";
        }

        ArrayList<Long> list = new ArrayList<>();
        list = check(list, 2, nr, dr);
        if (list.size() == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (!list.isEmpty()) {
            stringBuilder.append("1/" + list.get(0));
            list.remove(0);
            if (list.size() > 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static ArrayList<Long> check(ArrayList<Long> list, long start, long nr, long dr) {
        long newNr = start * nr - dr;
        if (newNr > 0) {
            list.add(start);
            return check(list, start + 1, newNr, start * dr);
        } else if (newNr == 0) {
            list.add(start);
            return list;
        } else {
            return check(list, Math.max(start + 1, dr / nr - start), nr, dr);
        }
    }


}