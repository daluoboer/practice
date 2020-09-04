package com.radish.mashibing.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description TestLockSupport
 * @Author Radish
 * @Date 2020-09-04 16:47
 */
public class TestLockSupport {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
                if (i == 1) LockSupport.park();
                if (i == 2) LockSupport.park();
            }
        });

        t.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5 Seconds later....");
        LockSupport.unpark(t);
        //???只有第一个unpark有用哎！后面就一直被阻塞住了！
        LockSupport.unpark(t);
        LockSupport.unpark(t);


    }
}
