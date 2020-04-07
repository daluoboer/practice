package com.example.concurrents;

import java.util.Date;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/19
 */

public class SleepWaitTest {
    public static void main(String[] args) throws InterruptedException{
        SleepWaitTest object = new SleepWaitTest();
        new Thread(()->{
            synchronized (object) {
                System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t等待打印文件...");
                try {
                    object.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t打印结束..");
            }
        }).start();

        Thread.sleep(1000);

        new Thread(()->{
            synchronized (object) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t" + i);
                }
            }
        }).start();

    }
}
