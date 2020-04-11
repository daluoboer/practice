package com.radish.thinking.unit21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/21
 */

class CircularSet{
    private int[] array;
    private int len;
    private int index = 0;

    public CircularSet(int size) {
        array = new int[size];
        len = size;
        for (int i = 0; i < size; i++) {
            array[i] = -1;
        }
    }
    public synchronized void add(int i) {
        array[index] = i;
        index = ++index % len;
    }
    public synchronized boolean contains(int val) {
        for (int i = 0; i < len; i++) {
            if (array[i] == val) return true;
        }
        return false;
    }
}
public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static CircularSet serials = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static class SerialChecker implements Runnable {
        @Override
        public void run() {
            while (true) {
                //哦！就是在这儿调了一个方法，然后这个方法有可能获取到重复的数而已，因为有多个线程同时调这个方法，然后线程调度器可能在某个不稳定状态切换线程，导致有问题~，所以给这个方法加个synchronized就行啦！
                int serial = SerialNumberGenerator.nextSerialNumber();
                if (serials.contains(serial)) {
                    System.out.println("Duplicate: " + serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < SIZE; i++)
            exec.execute(new SerialChecker());
        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("No dupicates detected");
            System.exit(0);
        }
    }
}
