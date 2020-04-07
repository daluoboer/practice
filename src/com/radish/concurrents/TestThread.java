package com.radish.concurrents;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/15
 */

public class TestThread {
    public static void main(String[] args) throws Exception {
        /*new EatThread().start();
        new DrinkThread().start();*/

       /* MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();*/

       /*new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println("I am a 匿名内部类的Thread.End.");
           }
       }).start();

       new Thread() {//尾部代码块，是对匿名内部类的语法糖
           @Override
           public void run() {
               System.out.println(currentThread().getName() + "\t" + currentThread().getId());
           }
       }.start();

       *//*Runnable是一个函数式接口，所以可以用Lambda表达式形式*//*
       Runnable runnable = () -> {
           System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId());
       };
       new Thread(runnable).start();*/


        /*MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask).start();


        boolean cancel = futureTask.cancel(false);
        System.out.println(futureTask.isCancelled());
        System.out.println(futureTask.isDone());*/
//        int sum = futureTask.get();
//        System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId() + "\t" + sum);



        /*new Thread(()-> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread-ReflectionTest").start();
        new Thread(()-> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread-B").start();*/

        Thread thread0 = new Thread(() -> {
            try {
                System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t太困了，让我睡10秒，中间有事儿叫我 . z Z Z。。。");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread0.start();

        Thread.sleep(2000);

        new Thread(()->{
            System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t醒醒，别睡了，起来干活啦！");
            thread0.interrupt();
        }).start();
    }
}

class EatThread extends Thread {
    @Override
    public void run() {
        System.out.println("Begin eating!\t" + new Date());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End eating!\t" + new Date());
    }
}

class DrinkThread extends Thread {
    @Override
    public void run() {
        System.out.println("Begin drinking!\t" + new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End drinking!\t" + new Date());
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(currentThread().getName() + "\t" + currentThread().getId());
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId());
    }
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId() + new Date());
        int sum = 0;
        for (int i = 0; i < 100000; i++) {
            sum += i;
        }
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId() + new Date());
        return sum;
    }
}