package com.codewars;

/**
 * https://www.codewars.com/kata/5264d2b162488dc400000001/train/java
 * success
 */
public class SpinWords {
    /**
     * clever
     * @param sentence
     * @return
     */
    public String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        for (int i=0; i<words.length; i++) {
            if (words[i].length() >= 5) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" ",words);
    }

    /*public String spinWords(String sentence) {
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            if (s.length() >= 5) {
                StringBuilder sb = new StringBuilder();
                for (int j = s.length() - 1; j >= 0; j--) {
                    sb.append(s.charAt(j));
                }
                strings[i] = sb.toString();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(strings[i]);
            if (i != strings.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }*/
}