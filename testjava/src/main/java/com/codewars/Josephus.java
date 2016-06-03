package com.codewars;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * http://www.codewars.com/kata/5550d638a99ddb113e0000a2/train
 */
public class Josephus {
    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        if (items == null || items.isEmpty()) {
            return items;
        }
        List<T> result = new ArrayList<>();
        Iterator<T> iterator = items.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            T t = iterator.next();
            count++;
            if (count == k) {
                count = 0;
                result.add(t);
                iterator.remove();
            }
            if (!iterator.hasNext()) {
                iterator = items.iterator();
                if (!iterator.hasNext()) {
                    break;
                }
            }
        }
        return result;
    }
}