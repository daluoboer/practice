package com.example.concurrents;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/20
 */

class Daemon implements Runnable {
    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + i + " started，");
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon() + "，");
        }
        while (true) {
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}
public class Daemons {
    public static void main(String[] args) throws Exception {

        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDeamon() = " + d.isDaemon() + "，");
        TimeUnit.SECONDS.sleep(3);

        /*后台线程创建出的线程也是后台线程*/
    }
}
