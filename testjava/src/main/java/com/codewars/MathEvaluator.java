package com.codewars;


import java.util.Stack;

/**
 * https://www.codewars.com/kata/52a78825cdfc2cfc87000005/train/java
 * 数字计算器
 * success
 */
public class MathEvaluator {

    public double calculate(String expression) {
        System.out.println("expression:" + expression);
        expression = expression.replaceAll(" ", "");
        return cal(expression, new Stack<>(), new Stack<>());
    }

    private static double cal(String expression, Stack<Double> stackResult, Stack<Character> symbolStack) {
        if (expression.length() == 0) {
            while (symbolStack.size() > 0) {
                stackResult.push(calcu(stackResult.pop(), stackResult.size() == 0 ? 0 : stackResult.pop(), symbolStack.pop()));
            }
            return stackResult.size() > 0 ? stackResult.pop() : 0;
        }
        char c = expression.charAt(0);
        expression = expression.substring(1);
        if (Character.isDigit(c)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c);
            while (expression.length() > 0 && (expression.charAt(0) == '.' || Character.isDigit(expression.charAt(0)))) {
                c = expression.charAt(0);
                stringBuilder.append(c);
                expression = expression.substring(1);
            }
            Double num = Double.parseDouble(stringBuilder.toString());
            if (symbolStack.size() > 0) {
                char symbol = symbolStack.pop();
                if (stackResult.size() == 0 && symbol == '-') {//-5
                    stackResult.push(-num);
                    return cal(expression, stackResult, symbolStack);
                }
                if (isPrioritySymbol(symbol)) {
                    stackResult.push(calcu(num, stackResult.size() == 0 ? 0 : stackResult.pop(), symbol));
                    return cal(expression, stackResult, symbolStack);
                }

                symbolStack.push(symbol);
            }
            stackResult.push(num);
            return cal(expression, stackResult, symbolStack);
        } else if (c == '(') {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            while (expression.length() > 0) {
                if (count == 0) {
                    break;
                }
                char cc = expression.charAt(0);
                if (cc == '(') {
                    count++;
                } else if (cc == ')') {
                    count--;
                }
                expression = expression.length() > 0 ? expression.substring(1) : "";
                if (count != 0) {
                    sb.append(cc);
                }
            }
            if (sb.length() > 0) {
                stackResult.push(cal(sb.toString(), new Stack<>(), new Stack<>()));
                while (symbolStack.size() > 0 && stackResult.size() > 1) {
                    if (isPrioritySymbol(symbolStack.peek())) {
                        stackResult.push(calcu(stackResult.pop(), stackResult.pop(), symbolStack.pop()));
                    } else {
                        break;
                    }
                }
            }
            return cal(expression, stackResult, symbolStack);
        } else if (isSymbol(c)) {
            if (isSecondePriority(c) && expression.length() > 0) {//连续两个加减号
                char nextC = expression.charAt(0);
                if (isSecondePriority(nextC)) {
                    expression = expression.substring(1);
                    if (c != nextC) {
                        c = '-';
                    } else {
                        c = '+';
                    }
                }
            }
            if (isPrioritySymbol(c) && expression.length() > 0) {//  /- *-
                char nextC = expression.charAt(0);
                if (nextC == '-') {
                    double num = stackResult.pop();
                    stackResult.push(-num);
                    expression = expression.substring(1);
                }
            }
            while (stackResult.size() > 1 && symbolStack.size() > 0) {
                char symbol1 = symbolStack.peek();
                boolean b = isSecondePriority(c);
                b |= (isPrioritySymbol(c) && isPrioritySymbol(symbol1));
                if (b) {
                    stackResult.push(calcu(stackResult.pop(), stackResult.pop(), symbolStack.pop()));
                } else {
                    break;
                }
            }
            symbolStack.push(c);
            return cal(expression, stackResult, symbolStack);
        } else {
            return 0;
        }
    }

    private static boolean isSymbol(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static boolean isPrioritySymbol(char c) {
        return c == '*' || c == '/';
    }

    private static boolean isSecondePriority(char c) {
        return c == '+' || c == '-';
    }

    private static double calcu(double d1, double d2, char symbol) {
        double r = 0;
        switch (symbol) {
            case '+':
                return d2 + d1;
            case '-':
                return d2 - d1;

            case '*':
                return d2 * d1;

            case '/':
                return d2 / d1;
        }
        return 0;
    }


}