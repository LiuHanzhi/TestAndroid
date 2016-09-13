package com.codewars;


import java.util.ArrayList;

/**
 * http://www.codewars.com/kata/54f8693ea58bce689100065f/train/java
 * success
 */
class Decomp {

    public static String decompose(String nrStr, String drStr) {
        System.out.println("nr:" + nrStr + ",dr:" + drStr);
        long nr = Long.parseLong(nrStr);
        if (nr == 0) {
            return "[]";
        }
        long dr = Long.parseLong(drStr);

        ArrayList<String> list = new ArrayList<>();
        list = check(list, 2, nr, dr);
        if (list.size() == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (!list.isEmpty()) {
            stringBuilder.append(list.get(0));
            list.remove(0);
            if (list.size() > 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static ArrayList<String> check(ArrayList<String> list, long start, long nr, long dr) {
        if (nr > dr) {
            list.add(String.valueOf(nr / dr));
            if (nr % dr == 0) {
                return list;
            }
            return check(list, 2, nr % dr, dr);
        }
        long newNr = start * nr - dr;
        if (newNr > 0) {
            list.add("1/" + start);
            return check(list, start + 1, newNr, start * dr);
        } else if (newNr == 0) {
            list.add("1/" + start);
            return list;
        } else {
            return check(list, Math.max(start + 1, dr / nr), nr, dr);
        }
    }


}