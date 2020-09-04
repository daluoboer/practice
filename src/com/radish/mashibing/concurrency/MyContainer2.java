package com.radish.mashibing.concurrency;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description MyContainer2
 * @Author Radish
 * @Date 2020-09-04 20:27
 */
public class MyContainer2<T> {
    LinkedList<T> list = new LinkedList<>();
    final int MAX = 10;
    ReentrantLock lock = new ReentrantLock();
    Condition producer = lock.newCondition();
    Condition consumer = lock.newCondition();

    public T get() {
        T t = null;
        try {
            lock.lock();
            while (list.size() == 0) {
                System.out.println(Thread.currentThread().getName() + " is waiting... size = " + list.size());
                consumer.await();
            }
            t = list.removeFirst();
            System.out.println(Thread.currentThread().getName() + " got a Object, size = " + list.size());
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;

    }

    public void put(T t) {
        try {
            lock.lock();
            while (list.size() == MAX) {
                System.out.println(Thread.currentThread().getName() + " is waiting... size = " + list.size());
                producer.await();//为啥这里不需要唤醒消费者呢？反而是底下加进去的时候才唤醒？因为现在没有加所以没有必要唤醒？好像有点道理
            }
            list.push(t);
            System.out.println(Thread.currentThread().getName() + " pushed a Object, size = " + list.size());
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    public static void main(String[] args) {
        MyContainer2 c = new MyContainer2();
        //消费者
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                for (int j = 0; j < 4; j++) {
                    c.get();
                }
            },"consumer" + i).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    c.put(new Object());
                }
            }, "producer" + i).start();
        }
    }
}
