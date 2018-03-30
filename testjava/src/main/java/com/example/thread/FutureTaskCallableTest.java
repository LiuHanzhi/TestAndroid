package com.example.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by liuhanzhi on 18/3/13.
 */

public class FutureTaskCallableTest {

    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                Thread.sleep(3000);
                return new Random().nextInt(100);
            }
        };
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();
        try {
//            Thread.sleep(5000);// 可能做一些事情
            System.out.println("start time:"+System.currentTimeMillis());
            System.out.println(future.get());
            System.out.println("end time:"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
