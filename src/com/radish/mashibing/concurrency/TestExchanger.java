package com.radish.mashibing.concurrency;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Description TestExchanger
 * @Author Radish
 * @Date 2020-09-04 15:58
 */
public class TestExchanger {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger();
        new Thread(()->{
            String s = "s1";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ".s = " + s);
        },"t1").start();

        new Thread(()->{
            String s = "s2";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ".s = " + s);
        },"t2").start();

        new Thread(()->{
            String s = "s3";
            try {
                s = exchanger.exchange(s,1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            } catch (TimeoutException e) {
//                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ".s = " + s);
        },"t3").start();
    }
}
