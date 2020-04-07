package com.radish.concurrents;

import java.util.Date;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/19
 */

public class JoinTest {
    public static void main(String[] args) {
//        new Thread(new ParentRunnable()).start();
        new Thread(new Runnable() {
            int sum = 0;
            @Override
            public void run() {
                long beginTime = System.currentTimeMillis();
                for (int i = 0; i < 99999; i++) {
                    sum+=1;
                    Thread.yield();
                }
                long endTime = System.currentTimeMillis();
                System.out.println("用时：" + (endTime-beginTime) + "毫秒！");
            }
        }).start();
    }
}

class ParentRunnable implements Runnable {
    @Override
    public void run() {
        Thread chileThread = new Thread(new ChildRunnable());
        chileThread.start();
        try {
            chileThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t父线程 Running..." );
        }

    }
}

class ChildRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t子线程 running...");
        }
    }
}
