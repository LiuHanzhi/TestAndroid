package com.example.thread;

/**
 * Created by liuhanzhi on 16/8/11.
 * 函数synchronized(this)使用
 * 结论:
 * 规则同函数中声明synchronized
 */
public class SynMethod2 {

    public static void main(String[] args) {
//        test1();
//        test11();
//        test3();
//        test4();
//        test44();
//        test5();
        test6();
    }

    /**
     * 类方法的同步锁, 不锁不加同步锁的方法
     */
    public static void test1() {
        final Counter2 counter = new Counter2();

        new Thread(new Runnable() {
            @Override
            public void run() {
                counter.test1();

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                counter.test2();
            }
        }).start();
    }

    /**
     * static synchronized 方法,不锁其他static方法
     */
    public static void test2() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Counter2.test3();

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                Counter2.test4();
            }
        }).start();
    }

    /**
     * static synchronized 方法, 会锁其他static synchronized方法
     */
    public static void test3() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Counter2.test3();

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                Counter2.test33();
            }
        }).start();
    }

    /**
     * synchronized方法, 会锁其他synchronized方法
     */
    public static void test4() {
        Counter2 counter = new Counter2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                counter.test1();

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                counter.test1();
//                counter.test11();
            }
        }).start();
    }

    /**
     * synchronized方法, 不会锁非本对象中的synchronized方法
     */
    public static void test44() {
        Counter2 counter = new Counter2();
        Counter2 counter1 = new Counter2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                counter.test1();

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                counter1.test1();
//                counter1.test11();
            }
        }).start();
    }

    /**
     * synchronized方法, 不锁synchronized static方法
     */
    public static void test5() {
        Counter2 counter = new Counter2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                counter.test1();

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                Counter2.test3();
            }
        }).start();
    }

    /**
     * synchronized static方法,不锁synchronized方法
     */
    public static void test6() {
        Counter2 counter = new Counter2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Counter2.test3();

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                counter.test1();
            }
        }).start();
    }

}
