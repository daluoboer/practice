package com.radish.mashibing.concurrency;

import java.util.concurrent.Semaphore;

/**
 * @Description TestSemaphare
 * @Author Radish
 * @Date 2020-09-04 15:14
 */
public class TestSemaphare {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2,false);
        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("t1 is running...");
                Thread.sleep(1000);
                System.out.println("t1 is running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }).start();

        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("t2 is running...");
                Thread.sleep(1000);
                System.out.println("t2 is running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }).start();

        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("t4 is running...");
                Thread.sleep(1000);
                System.out.println("t4 is running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }).start();

        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("t3 is running...");
                Thread.sleep(1000);
                System.out.println("t3 is running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }).start();
    }
}
