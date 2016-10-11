package com.example.thread;

public class MultThread {

    private static int count = 0;

    private final static Object lock = new Object();

    public static void inc() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().hashCode() + ": before " + count);
            //synchronized (lock){
            count++;
            //}
            System.out.println(Thread.currentThread().hashCode() + ": after " + count);
        }
    }

    public static void desc() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().hashCode() + ": before " + count);
            //synchronized (lock){
            count--;
            //}
            System.out.println(Thread.currentThread().hashCode() + ": after " + count);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    inc();
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    desc();
                }
            }).start();
        }
    }
}
