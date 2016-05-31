package com.example;

public class MyClass {

    public static void main(String[] args) {
        float t = 12.0f;
        System.out.println(t % 1 == 0);
        int i = (int) t;
        System.out.println(i);
        System.out.println(""+(t % 1 == 0 ?  (int) t : t));
    }
}
