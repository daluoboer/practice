package com.radish.mashibing.concurrency;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Description AtomicVsSycVsLongAddr
 * 1000个线程 加到100000的时候Syn已经比Atomic效率高了哎？1000000差不多，但是LongAdd效率真的高！
 * 10000个线程 一个线程加100000的时候依然是这样~
 * LongAdder原理是分段锁，内部搞个数组，把不同的线程对应到不同的地方，最后将结果加起来~大概是这样
 * Atomic-->CAS
 * @Author Radish
 * @Date 2020-09-04 08:20
 */
public class AtomicVsSycVsLongAddr {

    static long count1 = 0;
    static AtomicLong count2 = new AtomicLong(0);
    static LongAdder count3 = new LongAdder();
//    LongAccumulator
    public static void main(String[] args) throws Exception{

        int tNumbers = 100;

        int tAdd = 100000;

        Thread[] threads = new Thread[tNumbers];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < tAdd; j++) {
                    count2.getAndIncrement();
                }
            });
        }

        long start = System.currentTimeMillis();
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();
        long end = System.currentTimeMillis();
        System.out.println("Atomic:" + count2.get() + " time: " + (end-start));
        System.out.println("--------------------------------------------------------------");


        Object lock = new Object();

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < tAdd; j++) {
                    synchronized (lock) {
                        count1++;
                    }
                }
            });
        }
        start = System.currentTimeMillis();

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        end = System.currentTimeMillis();

        System.out.println("Synchronized: " + count1 + " time: " + (end - start));
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < tAdd; j++) {
                    count3.increment();
                }
            });
        }

        start = System.currentTimeMillis();

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        end = System.currentTimeMillis();

        System.out.println("count3: " + count3  + " time: " + (end-start));

    }
}
