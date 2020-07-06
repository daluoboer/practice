package com.radish.concurrencyArt;

/**
 * @description ThreadPool
 * @Author Radish
 * @Date 2020-06-24 17:26:10
 */

public interface ThreadPool<Job extends Runnable> {
    void execute(Job job);

    void shutdown();

    void addWorkers(int num);

    int getJobSize();
}
