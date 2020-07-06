package com.radish.concurrencyArt;

/**
 * @description FinalExample
 * @Author Radish
 * @Date 2020-07-02 13:49:21
 */

public class FinalExample {
    int i;
    final int j;
    static FinalExample obj;

    public FinalExample() {
        i = 1;
        j = 2;
    }

    public static void writer() {
        obj = new FinalExample();
        System.out.println("I am writer");
    }
    public static void reader() {
        FinalExample object = obj;
//        int a = object.i;
        int b = object.j;
        System.out.println("I am reader");
    }

    public static void main(String[] args) {
        Thread tW = new Thread(new Runnable(){
            @Override
            public void run() {
                writer();
            }
        });

        Thread tR = new Thread(new Runnable(){
            @Override
            public void run() {
                reader();
            }
        });

        tR.start();
        tW.start();
    }
}
