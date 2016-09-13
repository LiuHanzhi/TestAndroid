package com.example.thread;

/**
 * Created by liuhanzhi on 16/8/11.
 */
public class Counter {

    public static Counter instance;

    public int count;

    public static Counter get() {
        if (instance == null) {
            instance = new Counter();
        }
        return instance;
    }

    public int increase() {
        synchronized (instance) {
            count++;
            return count;
        }
    }
}
