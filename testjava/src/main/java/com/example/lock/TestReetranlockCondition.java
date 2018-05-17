package com.example.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestReetranlockCondition {

    private static int count;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (count < 100) {
                    try {
                        lock.lock();
                        condition.signal();
                        condition.await();
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
                        condition.await();
                        print("thread b");
                        condition.signal();
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
                        condition.await();
                        print("thread c");
                        condition.signal();
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
