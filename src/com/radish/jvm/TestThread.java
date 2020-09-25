package com.radish.jvm;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description TestThread
 * @Author Radish
 * @Date 2020-09-24 18:04
 */
public class TestThread {
    public static void main(String[] args) throws Exception {
//        System.out.println(Thread.currentThread().getState());
        Thread t = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " : " + Thread.currentThread().getState());
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.getName() + " : " + t.getState());
        t.start();
        Thread.sleep(50);

        System.out.println(t.getName() + " : " + t.getState());

//        t.wait();
        Thread.sleep(1000);

        System.out.println(t.getName() + " : " + t.getState());

        AtomicLong at = new AtomicLong(1);

        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    }
}
