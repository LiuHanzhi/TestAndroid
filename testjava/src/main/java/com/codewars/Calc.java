package com.codewars;

import java.util.Stack;

/**
 * http://www.codewars.com/kata/52f78966747862fc9a0009ae/train
 * success
 */
public class Calc {

    public double evaluate(String expr) {
        System.out.println("expr:" + expr);
        if (null == expr || "".equals(expr.trim())) {
            return 0;
        }
        String[] strings = expr.split(" ");
        if (null == strings || strings.length == 0) {
            return 0;
        }
        System.out.println("strings:" + strings);
        if (getCalTag(strings[strings.length - 1]) == -1) {
            return Double.parseDouble(strings[strings.length - 1]);
        }
        Stack<Double> desc = new Stack<>();
        for (int i = 0; i < strings.length; i++) {
            int tag = getCalTag(strings[i]);
            if (tag == -1) {
                desc.push(Double.parseDouble(strings[i]));
            } else {
                double d1 = desc.pop();
                double d2 = desc.pop();
                switch (tag) {
                    case 1:
                        desc.push(d2 + d1);
                        break;
                    case 2:
                        desc.push(d2 - d1);
                        break;
                    case 3:
                        desc.push(d2 * d1);
                        break;
                    case 4:
                        desc.push(d2 / d1);
                        break;
                }
            }
        }
        return desc.pop();
    }

    public static int getCalTag(String s) {
        switch (s) {
            case "+":
                return 1;
            case "-":
                return 2;
            case "*":
                return 3;
            case "/":
                return 4;
            default:
                return -1;
        }
    }
}