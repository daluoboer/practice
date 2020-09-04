package com.radish.mashibing.concurrency;

import java.util.LinkedList;

/**
 * @Description MyContainer
 *
 * 生产者消费者
 * 自己的阻塞容器
 *
 * @Author Radish
 * @Date 2020-09-04 20:13
 */
public class MyContainer<T> {
    LinkedList<T> list = new LinkedList<>();
    final Integer MAX = 10;
    public synchronized T get() {
        while (list.size() == 0) {
            try {
                this.wait();
                System.out.println(Thread.currentThread().getName() + " is waiting... size = " + list.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = list.removeFirst();
        System.out.println(Thread.currentThread().getName() + " got a Object, size = " + list.size());
        notifyAll();
        return t;
    }

    public synchronized void put(T t) {
        while (list.size() == MAX) {
            try {
                this.wait();
                System.out.println(Thread.currentThread().getName() + " is waiting... size = " + list.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.push(t);
        System.out.println(Thread.currentThread().getName() + " pushed a Object, size = " + list.size());
        notifyAll();
    }

    public static void main(String[] args) {
        MyContainer c = new MyContainer();
        //消费者
        for (int i = 0; i < 8; i++) {
            new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    c.get();
                }
            },"consumer" + i).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 40; j++) {
                    c.put(new Object());
                }
            }, "producer" + i).start();
        }
    }
}
