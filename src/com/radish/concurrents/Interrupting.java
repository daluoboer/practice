package com.example.concurrents;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/22
 */

class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run()");
    }
}

class IOBlocked implements Runnable {
    private InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            System.out.println("Waiting for read(): ");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked I/O");
            } else {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}

class SynchronisedBlocked implements Runnable {
    public synchronized void f() {
        while (true)
            Thread.yield();
    }

    public SynchronisedBlocked() {
        new Thread() {
            @Override
            public void run() {
                f();
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronisedBlocked.run()");
    }
}
public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getName());
        f.cancel(true);
        System.out.println("Interrupt sent to " + r.getClass().getName());
    }

    public static void main(String[] args) throws Exception {
        /*test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronisedBlocked());
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Aborting with System.exit(0)");
        System.exit(0);*/
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("I am going to sleep 3 s.");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("t.InterruptedException");
                }
                System.out.println("I am waking up.");
            }
        };
        t.start();
        Thread.sleep(1000);
        System.out.println(t.isInterrupted());
        System.out.println("t.interrupt()");
        t.interrupt();
        System.out.println(t.isInterrupted());
        Thread.sleep(1000);
        System.out.println(t.isInterrupted());
        Thread.sleep(4000);
        System.out.println(t.isInterrupted());
    }
}
