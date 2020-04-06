package com.radish.easyCoding.unit7;

import java.util.Date;
import java.util.concurrent.atomic.LongAdder;

public class VolatileNotAtomic {
    private static volatile long count = 0l;
    private static final int NUMBER = 10000;

    private static LongAdder adder = new LongAdder();
    public static void main(String[] args) {
        long startTime = new Date().getTime();
        Thread subtractThread = new SubtractThread();
        subtractThread.start();
        for (int i = 0; i < NUMBER; i++) {
            synchronized (VolatileNotAtomic.class){
                count++;
            }
            adder.increment();
        }

        while (subtractThread.isAlive()) {}
        System.out.println("count 最后的值为：" + count);
        System.out.println("adder 最后的值为：" + adder);
        long endTime = new Date().getTime();
        System.out.println(startTime);
        System.out.println(endTime);
        System.out.println(endTime-startTime);
    }

    private static class SubtractThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < NUMBER; i++) {
                synchronized (VolatileNotAtomic.class) {
                    count--;
                }
                adder.decrement();
            }
        }
    }
}


