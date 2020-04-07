package com.radish.concurrents;

import java.util.Date;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/19
 */

public class TestSleep {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        new Thread(()->{
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(1000);

        new Thread(()->{
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t" + i);
                }
            }
        }).start();
    }
}
