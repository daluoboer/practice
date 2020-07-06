package com.radish.concurrencyArt;

import java.util.concurrent.TimeUnit;

/**
 * @description Interrupted
 *
 * sleep为啥会抛出异常？睡觉的时候被吵醒了？抛出异常的时候会清除interrupted状态
 *
 * @Author Radish
 * @Date 2020-07-02 16:54:46
 */

public class Interrupted {
    public static void main(String[] args) throws Exception {
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
        SleepUtils.second(10);
    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
            }
        }
    }
}
