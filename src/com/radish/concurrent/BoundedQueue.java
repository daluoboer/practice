package com.radish.concurrent;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description BoundedQueue
 * @Author Radish
 * @Date 2020-04-23 14:22:10
 */

public class BoundedQueue {
    private LinkedList<Object> buffer; //生产者容器
    private int maxSize; //容器最大值
    private Lock lock;
    private Condition fullCondition;
    private Condition notFullCondition;

    public BoundedQueue(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        fullCondition = lock.newCondition();
        notFullCondition = lock.newCondition();
    }

    /**
     * 生产者
     * @param obj
     * @throws InterruptedException
     */
    public void put(Object obj) throws InterruptedException {
        lock.lock(); //获取锁
        try {
            while (maxSize == buffer.size()) {
                notFullCondition.await(); //满了，添加的线程进入等待状态
            }
            buffer.add(obj);
            fullCondition.signal(); //通知
        } finally {
            lock.unlock();
        }
    }

    /**
     * 消费者
     * @return
     * @throws InterruptedException
     */
    public Object get() throws InterruptedException {
        Object obj;
        lock.lock();
        try {
            while (buffer.size() == 0) {
                fullCondition.await(); //队列中没有数据了 线程进入等待状态
            }
            obj = buffer.poll();
            notFullCondition.signal(); //通知
        } finally {
            lock.unlock();
        }
        return obj;
    }

    public static void main(String[] args) {

    }
}

