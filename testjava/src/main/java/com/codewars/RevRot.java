package com.codewars;

/**
 * https://www.codewars.com/kata/56b5afb4ed1f6d5fb0000991/train/java
 */
class RevRot {

    public static String revRot(String strng, int sz) {
        if (sz <= 0 || strng == null || sz > strng.length()) {
            return "";
        }
        if (strng.length() % sz != 0) {
            strng = strng.substring(0, strng.length() - strng.length() % sz);
        }
        StringBuilder sb = new StringBuilder();
        while (strng.length() > 0) {
            String s = strng.substring(0, sz);
            sb.append(sort(s));
            strng = strng.substring(sz);
        }
        return sb.toString();
    }

    public static String sort(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int it = s.charAt(i) - 48;
            if (it % 2 != 0) {
                count++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (count % 2 == 0) {
            //reverse
            for (int i = s.length() - 1; i >= 0; i--) {
                stringBuilder.append(s.charAt(i));
            }
        } else {
            for (int i = 1; i < s.length(); i++) {
                stringBuilder.append(s.charAt(i));
            }
            stringBuilder.append(s.charAt(0));
        }
        return stringBuilder.toString();
    }
}