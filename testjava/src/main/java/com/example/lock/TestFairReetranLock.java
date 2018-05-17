package com.example.lock;

import java.util.concurrent.locks.ReentrantLock;

public class TestFairReetranLock  {


    private static int count;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {

                while (count < 100) {
                    try {
                        lock.lock();
                        print("thread a");
                    } catch (Exception e) {

                    } finally {
                        lock.unlock();
                    }
                }

            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    try {
                        lock.lock();
                        print("thread b");
                    } catch (Exception e) {

                    } finally {
                        lock.unlock();
                    }

                }
            }
        });
        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    try {
                        lock.lock();
                        print("thread c");
                    } catch (Exception e) {

                    } finally {
                        lock.unlock();
                    }
                }

            }
        });
        a.start();
        b.start();
        c.start();
    }

    private static void print(String name) {
        System.out.println("name:" + name + ", count:" + count++);
    }
}
