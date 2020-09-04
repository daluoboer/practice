package com.radish.mashibing.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @Description Lambda1
 * @Author Radish
 * @Date 2020-09-04 10:34
 */
public class Lambda1 {
    /*volatile */boolean running = true;
    //给类加volatile并没有啥用啊
    volatile static Lambda1 T = new Lambda1();

    void m() {
        System.out.println("m() start");
        while (running) {

        }
        System.out.println("m() end");
    }

    public static void main(String[] args) {
        new Thread(T::m).start();
        //new Thread(new Runnable(){run(){m();}})

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        T.running = false;
    }

}
