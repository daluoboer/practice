package com.radish.mashibing.concurrency;

/**
 * @Description T01_YeildJoin
 * @Author Radish
 * @Date 2020-09-04 09:47
 */
public class T01_YeildJoin {
    public void testJoin() {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("B" + i);
                if (i == 6) Thread.yield();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        t2.start();
    }

    public void testYield() {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("B" + i);
                Thread.yield();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }

    public static void main(String[] args) {
        T01_YeildJoin tt = new T01_YeildJoin();
        tt.testJoin();
//        tt.testYield();
    }
}
