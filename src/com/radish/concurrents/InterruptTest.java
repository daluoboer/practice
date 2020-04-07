package com.radish.concurrents;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/19
 */

public class InterruptTest {
    public static void main(String[] args) {

        Thread thread = new Thread(new MyRunnable2());
        thread.start();
        boolean interrupted = thread.isInterrupted();
        System.out.println("interrupted = " + interrupted);
        thread.interrupt();
        boolean interrupted1 = thread.isInterrupted();
        System.out.println("interrupted1 = " + interrupted1);

        boolean interrupted2 = Thread.interrupted();
        System.out.println("interrupted2 = " + interrupted2);
    }
}
class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException\t" + Thread.currentThread().isInterrupted());
            }
        }
    }
}
