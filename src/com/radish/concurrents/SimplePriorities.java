package com.example.concurrents;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/20
 */

public class SimplePriorities implements Runnable {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
//        Thread.NORM_PRIORITY
        exec.shutdown();

        /*哎？为啥人家的前面全是第六根线程，我的咋分布的这么均匀啊，一点都没有体现出它的优先呀，嗨，奇怪了很*/
        /*嗷！因为这个优先级与多数操作系统都不能映射得很好！windows有7个优先级且不是固定的，Sun的Solaris有2个优先级...原来如此~*/
        /*所以如果要用优先级就写它的enum那几个值（虽然可能也没啥用）*/
    }
    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double)i;
                if (i%1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) return;
        }
    }
}
