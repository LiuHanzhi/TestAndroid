package com.example.threadpool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuhanzhi on 18/3/8.
 */

public class main {

    public static void main(String[] args) {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 10, 0, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(), threadFactory("OkHttp Dispatcher", false));
        for (int i = 0; i < 10; i++) {
            MyRunnable myRunnable = new MyRunnable(i);
            executorService.execute(myRunnable);
        }

        try {
            System.out.println("start sleeping...");
            Thread.sleep(10000);
            System.out.println("end sleeping...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 10; i < 20; i++) {
            MyRunnable myRunnable = new MyRunnable(i);
            executorService.execute(myRunnable);
        }


    }

    private static class MyRunnable implements Runnable {

        private int i;

        public MyRunnable(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println("start run index=" + i + " ,ThreadId=" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end run index=" + i + " ,ThreadId=" + Thread.currentThread().getId());
        }
    }


    public static ThreadFactory threadFactory(final String name, final boolean daemon) {
        return new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                Thread result = new Thread(runnable, name);
                result.setDaemon(daemon);
                return result;
            }
        };
    }


}
