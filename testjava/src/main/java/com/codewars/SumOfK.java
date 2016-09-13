package com.codewars;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * https://www.codewars.com/kata/55e7280b40e1c4a06d0000aa/train/java
 * success
 */
public class SumOfK {

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        if (ls == null || ls.size() < k) {
            return null;
        }
        System.out.println("t:" + t + ",k:" + k + ",ls:" + ls.toString());
        Set<List<Integer>> rSet = new LinkedHashSet<>();
        index = 1;
        loopCount = 0;
        subSelect(new Stack<>(), rSet, ls, 0, k);
        Integer result = 0;
        Iterator<List<Integer>> iterator = rSet.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            List<Integer> list = iterator.next();
            System.out.println("list【" + count++ + "】:" + list);
            Integer r = 0;
            for (Integer i : list) {
                r += i;
            }
            if (r <= t && r > result) {
                result = r;
            }
        }
        return result != 0 ? result : null;

    }

    public static int index = 1;

    public static int loopCount = 0;

    public static void subSelect(Stack<Integer> rList, Set<List<Integer>> rSet, List<Integer> ls, int header, int k) {
        for (int i = header; i < ls.size() - k + rList.size() + 1; i++) {
            System.out.println("i:" + i);
            if (index < k) {
                rList.add(ls.get(i));
                index += 1;
                if (loopCount + 1 < k) {
                    loopCount++;
                    subSelect(rList, rSet, ls, i + 1, k);
                }
            } else if (index == k) {
                List<Integer> l = new ArrayList<>();
                l.addAll(rList);
                l.add(ls.get(i));
                rSet.add(l);
                if (loopCount + 1 < k) {
                    loopCount++;
                    subSelect(rList, rSet, ls, i + 1, k);
                }
            }
            if (i == ls.size() - k + rList.size() && rList.size() > 0) {
                rList.pop();
                index -= 1;
                loopCount--;
            }
        }
    }
}
