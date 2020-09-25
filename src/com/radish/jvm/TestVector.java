package com.radish.jvm;

import java.util.Vector;

/**
 * @Description TestVector
 * 咦这咋不抛出异常勒
 * @Author Radish
 * @Date 2020-09-24 19:53
 */
public class TestVector {
    private static Vector<Integer> vector  =new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            int length = 20;
            Thread[] removes = new Thread[length];
            Thread[] prints = new Thread[length];

            for (int i = 0; i < length; i++) {

                Thread removeThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
//                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            vector.remove(i);
                        }
//                    }
                    }
                });

                removes[i] = removeThread;
            }
            for (int i = 0; i < length; i++) {
                Thread printThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
//                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            System.out.println(vector.get(i));
                        }
//                    }
                    }
                });
                prints[i] = printThread;
            }

            for (int i = 0; i < length; i++) {
                removes[i].start();
                prints[i].start();
            }

            while (Thread.activeCount() > 20);

        }
    }
}
