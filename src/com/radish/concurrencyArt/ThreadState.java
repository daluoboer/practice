package com.radish.concurrencyArt;

/**
 * @description ThreadState
 * @Author Radish
 * @Date 2020-07-02 15:38:19
 */

public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();
    }
    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("TimeWaiting");
                SleepUtils.second(10);
            }
        }
    }

    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    System.out.println("Blocked");
                    SleepUtils.second(10);
                }
            }
        }
    }
}
