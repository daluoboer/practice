package com.radish.mashibing.concurrency;

/**
 * @Description PrintA1B2C3D4
 * @Author Radish
 * @Date 2020-09-04 19:58
 */
public class PrintA1B2C3D4 {
    volatile int aa = 1;

    public void test() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                synchronized (this) {
                    while (aa%2 == 0){
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print((char) ('A' + i));
                    aa++;
                    notify();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                synchronized (this) {
                    while (aa%2 != 0) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(i+1);
                    aa++;
                    notify();
                }
            }
        });

        t1.start();
        t2.start();
    }
    public static void main(String[] args) {
        PrintA1B2C3D4 printA1B2C3D4 = new PrintA1B2C3D4();
        printA1B2C3D4.test();
    }
}
