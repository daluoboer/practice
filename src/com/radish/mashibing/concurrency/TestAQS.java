package com.radish.mashibing.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description TestAQS
 * @Author Radish
 * @Date 2020-09-05 14:48
 */
public class TestAQS {
    public static void main(String[] args) {
        /*ReentrantLock lock = new ReentrantLock();
        lock.lock();

        System.out.println("ok");
        lock.unlock();
        System.out.println("unLock()");

        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("哈哈哈哈哈哈哈");

        WeakHashMap map = new WeakHashMap();
        map.put(1,"呵呵呵呵呵呵呵");

        map.get(1);

        map.get(null);

        Vector<Object> objects = new Vector<>();

        objects.add('1');

        Hashtable<Integer,String> table = new Hashtable<>();

        table.put(1,"11111");

        ConcurrentHashMap<Integer,String> concurrentHashMap = new ConcurrentHashMap<>();

        concurrentHashMap.put(2,"22222");

        CopyOnWriteArrayList<Object> objects1 = new CopyOnWriteArrayList<>();

        DelayQueue<Delayed> delayeds = new DelayQueue<>();*/

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,5,60,TimeUnit.SECONDS,new ArrayBlockingQueue<>(5));

        for (int i = 0; i < 11; i++) {
            poolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName());
                System.out.println(poolExecutor);
            });
        }

        /*poolExecutor.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });

        poolExecutor.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });*/


        Thread thread = new Thread();
    }
}
