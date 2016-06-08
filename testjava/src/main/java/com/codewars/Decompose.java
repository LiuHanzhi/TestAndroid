package com.codewars;

import java.util.Stack;

/**
 * http://www.codewars.com/kata/54eb33e5bc1a25440d000891/train/java
 * success
 */
public class Decompose {

    public String decompose(long n) {
        System.out.println("n:" + n);
        Stack<Long> list = new Stack<>();
        list = deCompose(list, n - 1, (long) Math.pow(n, 2));
        if (null != list && list.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = list.size() - 1; i >= 0; i--) {
                stringBuilder.append(list.get(i));
                if (i != 0) {
                    stringBuilder.append(" ");
                }
            }
            return stringBuilder.toString();
        } else {
            return null;
        }
    }

    /**
     * @param list
     * @param start
     */
    public Stack<Long> deCompose(Stack<Long> list, long start, long total) {
        long powStart = (long) Math.pow(start, 2);
        if (powStart <= total) {
            if (list.contains(start)) {
                return popOut(list, start, total);
            } else {
                if (powStart == total) {
                    list.add(start);
                    return list;
                }
                if (start <= 1) {
                    return popOut(list, start, total);
                }
                list.add(start);
                total -= powStart;
                long startNew = (long) Math.sqrt(total);
                if (start <= startNew) {
                    start -= 1;
                } else {
                    start = startNew;
                }
                return deCompose(list, start, total);
            }
        } else {
            start -= 1;
            if (start <= 1) {
                return popOut(list, start, total);
            }
            return deCompose(list, start, total);
        }
    }

    private Stack<Long> popOut(Stack<Long> list, long start, long total) {
        if (list.size() == 0) {
            return null;
        }
        long last = list.pop();
        total += Math.pow(last, 2);
        start = last - 1;
        if (start == 0) {
            if (list.size() == 0) {
                return null;
            }
            last = list.pop();
            total += Math.pow(last, 2);
            start = last - 1;
        }
        return deCompose(list, start, total);
    }

    /**
     * clever
     Stack<Long> stack;

     public String decompose(long n) {
     stack = new Stack<Long>();
     this.check(n * n, n-1);
     StringBuilder result = new StringBuilder().append(" ");
     while (!stack.isEmpty()){
     result.append(stack.pop() + " ");
     }
     return result.toString().trim();
     }

     public void check(long sum, long i){
     if(sum == 0L) return;
     if((i == 0L) && !stack.isEmpty()) {
     long up = stack.pop();
     check(sum + up * up, up - 1);
     } else {
     stack.push(i);
     check(sum - i * i, Math.min(i - 1, (long) Math.sqrt(sum - i * i)));
     }
     }
     */
}