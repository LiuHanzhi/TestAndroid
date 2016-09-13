package com.example.thread;

public class MultThread {

    private static int count = 0;

    private final static Object lock = new Object();

    public static void inc() {
        for (int i = 0; i <= 10000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock){
                count++;
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            new Thread(
                    new Runnable() {

                        public void run() {
                            inc();
                        }
                    }
            ).start();
        }
    }
}
