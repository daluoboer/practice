package com.radish.mashibing.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description TestReadWriteLock
 * @Author Radish
 * @Date 2020-09-04 14:54
 */
public class TestReadWriteLock {
    public static ReentrantLock lock = new ReentrantLock();

    public static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read over!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("write over!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
//        Runnable readR = () -> read(lock);
        Runnable readR = ()-> read(readLock);
//        Runnable writeR = () -> write(lock);
        Runnable writeR = ()-> write(writeLock);
        for (int i = 0; i < 18; i++) new Thread(readR).start();
        for (int i = 0; i < 2; i++) new Thread(writeR).start();
    }
}
