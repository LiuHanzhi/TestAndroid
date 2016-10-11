package com.example.thread;

/**
 * Created by liuhanzhi on 16/8/11.
 */
public class Counter3 {

    public int count;

    private final Object lock1 = new Object();

    private final Object lock2 = new Object();

    public void test1() {
        synchronized (lock1) {

            System.out.println("test1 before");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test1 after");
        }
    }

    public void test11() {
        synchronized (lock2) {
            System.out.println("test11 before");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test11 after");
        }
    }

}
