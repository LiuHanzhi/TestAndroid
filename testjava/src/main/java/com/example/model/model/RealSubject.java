package com.example.model.model;

/**
 * Created by liuhanzhi on 18/3/16.
 */

public class RealSubject implements Subject {
    @Override
    public void doSomething(String str) {
        System.out.println("do something-->" + str);
    }
}
