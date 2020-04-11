package com.radish.thinking.unit21;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/31
 */

public class VolatileTest {
    public static volatile int race = 0;
    public static void increase() {
        race++;
    }
    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
//        Unsafe unsafe = Unsafe.getUnsafe();
//        unsafe.getAndSetInt(1,1,1);
        synchronized (Integer.valueOf(race)) {

        }
        ReentrantLock lock = new ReentrantLock();
        String s = "1";
        s.substring(1);
        s.charAt(1);
        s.split(" ");
        s.toCharArray();
        s+="1";
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        Set<Thread> threads1 = allStackTraces.keySet();
        Set<Map.Entry<Thread, StackTraceElement[]>> entries = allStackTraces.entrySet();
        System.out.println("\n"+Thread.activeCount() + "个线程： ");

        for (Map.Entry<Thread,StackTraceElement[]> entry : entries) {
            System.out.print(entry.getKey() + ": " + entry.getValue() + "\t");
        }

       /* Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            System.out.println(threads[i].getName());
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            //e....也看到到底是那俩线程一直存活啊o知道了，是main和Attach Listener是一根system线程
//            System.out.println(Thread.activeCount());
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Set<Thread> threads1 = allStackTraces.keySet();
            *//*System.out.println("\n"+Thread.activeCount() + "个线程： ");
            for (Thread t : threads1) {
                System.out.print(t.getName() + "\t");
            }*//*
            Set<Map.Entry<Thread, StackTraceElement[]>> entries = allStackTraces.entrySet();
            System.out.println("\n"+Thread.activeCount() + "个线程： ");

            for (Map.Entry<Thread,StackTraceElement[]> entry : entries) {
                System.out.print(entry.getKey() + ": " + entry.getValue() + "\t");
            }

            System.out.println(Thread.currentThread().getName());
            Thread.yield();
        }

        System.out.println(race);*/
    }
}
