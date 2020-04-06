package com.radish.easyCoding.unit7;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch count = new CountDownLatch(3);
        Thread thread1 = new TranslateThread("1st content",count);
        Thread thread2 = new TranslateThread("2nd content",count);
        Thread thread3 = new TranslateThread("3rd content",count);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            count.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有线程执行完毕");
    }
}

class TranslateThread extends Thread {
    private String content;
    private final CountDownLatch count;

    public TranslateThread(String content, CountDownLatch count) {
        this.content = content;
        this.count = count;
    }

    @Override
    public void run() {
        if (Math.random() > 0.5) {
            throw new RuntimeException("原文存在非法字符");
        }
        System.out.println(content + "的翻译已经完成，译文是^$#!%()&^%");
        count.countDown();
    }
}
