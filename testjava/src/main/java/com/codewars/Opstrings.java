package com.codewars;

/**
 * https://www.codewars.com/kata/56dbeec613c2f63be4000be6/train/java
 */
class Opstrings {

    public static String diag1Sym(String strng) {
        char[][] chars = string2Chars(strng);
        if (chars == null) {
            return null;
        }
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars[i].length; j++) {
                char tmp = chars[i][j];
                chars[i][j] = chars[j][i];
                chars[j][i] = tmp;
            }
        }
        return chars2String(chars);
    }

    public static String rot90Clock(String strng) {
        // your code
        char[][] chars = string2Chars(strng);
        if (chars == null) {
            return null;
        }
        char[][] result = new char[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                result[i][j] = chars[chars.length - j - 1][i];
            }
        }
        return chars2String(result);
    }

    public static String selfieAndDiag1(String strng) {
        // your code
        char[][] chars = string2Chars(strng);
        if (chars == null) {
            return null;
        }
        char[][] result = new char[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                result[i][j] = chars[j][i];
            }
        }
        return chars2String(chars, result);
    }

    public static char[][] string2Chars(String strng) {
        String[] arr = strng.split("\n");
        int n = arr.length;
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = arr[i];
            if (s.length() != n) {
                return null;
            }
            for (int j = 0; j < n; j++) {
                chars[i][j] = s.charAt(j);
            }
        }
        return chars;
    }

    public static String chars2String(char[][] chars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                stringBuilder.append(chars[i][j]);
            }
            if (i != chars.length - 1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }


    public static String chars2String(char[][] chars, char[][] chars2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                stringBuilder.append(chars[i][j]);
            }
            stringBuilder.append('|');
            for (int j = 0; j < chars[i].length; j++) {
                stringBuilder.append(chars2[i][j]);
            }
            if (i != chars.length - 1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

}

