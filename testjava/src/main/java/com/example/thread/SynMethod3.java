package com.example.thread;

/**
 * Created by liuhanzhi on 16/8/11.
 * 函数synchronized(this)使用
 * 结论:
 * 在方法内部使用synchronized(lock)时,如果使用两个不同的lock对象,相当于是两个不同的锁,彼此不受影响。
 */
public class SynMethod3 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 类方法的同步锁, 不锁不加同步锁的方法
     */
    public static void test1() {
        final Counter3 counter = new Counter3();

        new Thread(new Runnable() {
            @Override
            public void run() {
                counter.test1();

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                counter.test11();
            }
        }).start();
    }

}
