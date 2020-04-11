package com.radish.thinking.unit21;

import java.util.Date;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/19
 */

public class WaitNotifyTest {
    public static void main(String[] args) {

        WaitNotifyTest waitNotifyTest = new WaitNotifyTest();
        new Thread(()->{
            try {
                waitNotifyTest.printFile();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                waitNotifyTest.printFile();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t睡觉1秒钟，目的是让上面的线程先执行，即先执行wait（）");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            waitNotifyTest.notifyPrint();
        }).start();
    }

    private synchronized void printFile() throws InterruptedException {
        System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t等待打印文件...");
        this.wait();
        System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t打印结束..");
    }

    private synchronized void notifyPrint() {
        this.notify();
        System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t通知完成...");
    }
}
