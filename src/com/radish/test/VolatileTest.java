package com.radish.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {
    private static final int THREAD_COUNT = 20;
    public static AtomicInteger count = new AtomicInteger(0);
    public static void increase(){
        count.incrementAndGet();
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        System.out.println("ks:綫程數量："+Thread.activeCount());
        for(int i = 0; i < THREAD_COUNT; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < 1; i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 2){
            Thread.yield();
            System.out.println(count);
            System.out.println("輸出啊:綫程數量："+Thread.activeCount());
        }

    }
    /*public static volatile int race = 0;
    public static void increase(){
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for(int i = 0;i<THREADS_COUNT;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0;i<1000;i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }
//        while(Thread.activeCount()>1){
//            Thread.yield();
//        }
        System.out.println(race);
    }*/
    /*volatile boolean shutdownRequested;
    public void shutdown(){
        shutdownRequested = true;
    }
    public void doWork(){
        while (!shutdownRequested){
            //do stuff
        }
    }*/
    /*Map<String,Integer> configOptions = new HashMap<>();
    char[] configText;
    volatile boolean initialized = false;

    Random ran = new Random();
    int a = ran.nextInt();*/


}
