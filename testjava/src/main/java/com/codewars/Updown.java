package com.codewars;

/**
 * https://www.codewars.com/kata/56cac350145912e68b0006f0/train/java
 * success
 */
class Updown {

    public static String arrange(String strng) {
        String[] strings = strng.split(" ");
        if (strings == null || strings.length < 2) {
            return strng;
        }
        for (int i = 1; i < strings.length; i++) {
            if (i % 2 == 0) {
                if (strings[i].length() > strings[i - 1].length()) {
                    String tmp = strings[i];
                    strings[i] = strings[i - 1];
                    strings[i - 1] = tmp;
                }
            } else {
                if (strings[i].length() < strings[i - 1].length()) {
                    String tmp = strings[i];
                    strings[i] = strings[i - 1];
                    strings[i - 1] = tmp;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (i % 2 == 1) {
                stringBuilder.append(strings[i].toUpperCase());
            } else {
                stringBuilder.append(strings[i].toLowerCase());
            }
            if (i != strings.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}