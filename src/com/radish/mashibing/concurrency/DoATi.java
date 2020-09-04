package com.radish.mashibing.concurrency;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description DoATi
 * 实现一个容器提供俩接口 add,size
 * 写俩线程，一个往里写1-10的数，另一个监测，到5时退出
 *
 *
 * @Author Radish
 * @Date 2020-09-04 19:43
 */
public class DoATi {
    static Thread t2 = null;

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                if (i == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
                System.out.println(i);
            }
        });

        t2 = new Thread(()->{
            LockSupport.park();
            System.out.println("t2 over");
            LockSupport.unpark(t1);
        });

        t1.start();
        t2.start();

    }
}
