package com.radish.mashibing.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description TestThreadPool
 * @Author Radish
 * @Date 2020-09-06 09:12
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Executors.newFixedThreadPool(5);
    }
}
