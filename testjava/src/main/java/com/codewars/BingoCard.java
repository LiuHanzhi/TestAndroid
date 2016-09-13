package com.codewars;

import java.util.*;

/**
 * https://www.codewars.com/kata/566d5e2e57d8fae53c00000c/train/java
 * success
 */
public class BingoCard {

    public static String[] getCard() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int jSize = i != 2 ? 5 : 4;
            char c = 'B';
            switch (i) {
                case 1:
                    c = 'I';
                    break;
                case 2:
                    c = 'N';
                    break;
                case 3:
                    c = 'G';
                    break;
                case 4:
                    c = 'O';
                    break;
            }
            for (int j = 0; j < jSize; j++) {
                String s = getS(i, c);
                while (list.contains(s)) {
                    s = getS(i, c);
                }
                list.add(s);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    private static String getS(int i, char c) {
        int r = new Random().nextInt(15) + (i) * 15 + 1;
        String s = String.valueOf(c) + String.valueOf(r);
        System.out.println(s);
        return s;
    }
}

