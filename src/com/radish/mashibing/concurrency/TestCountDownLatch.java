package com.radish.mashibing.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * @Description TestCountDownLatch
 * @Author Radish
 * @Date 2020-09-04 11:09
 */
public class TestCountDownLatch {
    public static void useCountDownLatch() {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        for (int i = 0; i < threads.length; i++) {
            int finalI = i;
            threads[i] = new Thread(()->{
                int result = 0;
                for (int j = 0; j < 100; j++) {
                    result++;
                }
                System.out.println(finalI + " " + result);
                latch.countDown();
            });
        }

        for (Thread t : threads) {
            t.start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("latch end.");
    }


    public static void useJoin() {
        Thread[] threads = new Thread[100];

    }

    public static void main(String[] args) {
        useCountDownLatch();
    }
}
