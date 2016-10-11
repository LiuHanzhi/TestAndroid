package com.example.thread;

/**
 * Created by liuhanzhi on 16/8/11.
 */
public class Counter2 {

    public int count;

    public void test1() {
        synchronized (this) {

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
        synchronized (this) {
            System.out.println("test11 before");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test11 after");
        }
    }

    public void test2() {
        System.out.println("test11");
    }

    public synchronized static void test3() {
        System.out.println("test3 before");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test3 after");
    }

    public static void test4() {
        System.out.println("test4");
    }

    public synchronized static void test33() {
        System.out.println("test33 before");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test33 after");
    }
}
