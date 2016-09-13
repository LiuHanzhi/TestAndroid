package com.codewars;

/**
 * https://www.codewars.com/kata/5679aa472b8f57fb8c000047/train/java
 * success
 */
public class Kata {

    public static int findEvenIndex(int[] arr) {
        if (arr.length < 3) {
            return -1;
        }
        int index = 1;
        long lSum = arr[0];
        long rSum = sum(arr, index + 1, arr.length);
        while (index < arr.length - 1) {
            if (lSum == rSum) {
                return index;
            }
            lSum += arr[index];
            index++;
            rSum -= arr[index];
        }
        return -1;
    }

    public static long sum(int[] arr, int start, int end) {
        long result = 0;
        for (int i = start; i < end; i++) {
            result += arr[i];
        }
        return result;
    }
}