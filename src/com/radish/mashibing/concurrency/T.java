package com.radish.mashibing.concurrency;

/**
 * @Description T1
 * @Author Radish
 * @Date 2020-08-28 09:09
 */
public class T {
    public synchronized void m1() {
        System.out.println("m1.start.....");
        m2();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1.end..");
    }

    public void m2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }

    public Object a = null;
    public void m3() {
        synchronized(a) {
            System.out.println("I am a");
        }
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m3,"t3").start();
//        new Thread(t::m2,"t2").start();

    }
}


