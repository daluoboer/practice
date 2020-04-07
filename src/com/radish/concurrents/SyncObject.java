package com.radish.concurrents;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/22
 */

class DualSynch {
    private Object syncObject = new Object();
    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
//            Thread.yield();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void f2() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f2()");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void g(){
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
//                Thread.yield();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void g2() {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g2()");
//                Thread.yield();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
public class SyncObject {
    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        new Thread() {
            @Override
            public void run() {
                ds.g();
            }
        }.start();
        ds.g2();
    }
}
