package com.codewars;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * http://www.codewars.com/kata/555624b601231dc7a400017a/train/java
 * success
 */
public class JosephusSurvivor {
    public static int josephusSurvivor(final int n, final int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i + 1);
        }
        Iterator<Integer> iterator = arrayList.iterator();
        int count = 0;
        while (arrayList.size() > 1) {
            count++;
            if (!iterator.hasNext()) {
                iterator = arrayList.iterator();
            }
            iterator.next();
            if (count == k) {
                count = 0;
                iterator.remove();
            }
        }
        return arrayList.get(0);
    }
}