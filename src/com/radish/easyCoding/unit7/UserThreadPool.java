package com.radish.easyCoding.unit7;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UserThreadPool {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue(2);
        UserThreadFactory f1 = new UserThreadFactory("第1机房");
        UserThreadFactory f2 = new UserThreadFactory("第2机房");
        UserRejectHandler handler = new UserRejectHandler();
        ThreadPoolExecutor threadPoolFirst = new ThreadPoolExecutor(1,2,60, TimeUnit.SECONDS,queue,f1,handler);
        ThreadPoolExecutor threadPoolSecond = new ThreadPoolExecutor(1,2,60,TimeUnit.SECONDS,queue,f2,handler);

        Runnable task = new Task();
        for (int i = 0; i < 200; i++) {
            threadPoolFirst.execute(task);
            threadPoolSecond.execute(task);
        }
    }
}
