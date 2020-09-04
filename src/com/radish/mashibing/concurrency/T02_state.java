package com.radish.mashibing.concurrency;

/**
 * @Description T02_state
 * @Author Radish
 * @Date 2020-09-04 09:57
 */
public class T02_state {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(getState());
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        System.out.println(t.getState());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getState());
    }
}
