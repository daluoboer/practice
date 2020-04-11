package com.radish.thinking.unit21;

import java.util.stream.IntStream;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/19
 */

public class DaemonTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                IntStream.range(0, 5).forEach(i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\ti = " + i);
                });
            }
        });
//        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 2; i++) {
            System.out.println(Thread.currentThread().getName() + "\ti = " + i);
        }

        System.out.println("主线程执行结束，非后台子线程仍然继续执行，主线程和用户线程的生命周期相互独立。");
//        System.out.println("主线程死亡，后台子线程也要陪着一起死！");
    }
}
