package com.example.thread;

/**
 * Created by liuhanzhi on 16/8/11.
 */
public class SynchronizeThread {

    public static void main(String[] args) {
        final Counter counter = Counter.get();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    int count = counter.increase();
                    System.out.println("1111111111" + "---count:" + count);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        for (int i = 0; i < 100; i++) {
            int count = counter.increase();
            System.out.println("22222222" + "---count:" + count);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
