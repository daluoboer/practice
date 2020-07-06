package com.radish.concurrencyArt;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @description FinalReferenceExample
 * @Author Radish
 * @Date 2020-07-02 14:01:15
 */

public class FinalReferenceExample {
    final int[] intArray;
    static FinalReferenceExample obj;

    public FinalReferenceExample() {
        intArray = new int[1];
        intArray[0] = 1;
    }

    public static void writerOne() {
        obj = new FinalReferenceExample();
        System.out.println("writeOne");
    }

    public static void writerTwo() {
        obj.intArray[0] = 2;
        System.out.println("writeTwo");
    }

    public static void reader() {
        if (obj != null) {
            int temp1 = obj.intArray[0];
        }
        System.out.println("reader");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                writerOne();
            }
        });

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                writerTwo();
            }
        });

        Thread t3 = new Thread(new Runnable(){
            @Override
            public void run() {
                reader();
            }
        });

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*t2.start();
        t1.start();
        t3.start();*/

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName() + ", state: " + threadInfo.getThreadState());
        }
    }
}
