package com.radish.mashibing.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @Description T01_Reentrantlock1
 * @Author Radish
 * @Date 2020-09-04 08:56
 */
public class T01_Reentrantlock1 {
    synchronized void m1() {
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if (i == 2) m2();
        }
    }

    synchronized void m2() {
        System.out.println("m2...");
    }

    public static void main(String[] args) {
        T01_Reentrantlock1 r1 = new T01_Reentrantlock1();
        new Thread(r1::m1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        new Thread(r1::m2).start();
    }
}
