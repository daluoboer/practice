package com.example.testTimerTask;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @Description
 * @Author Radish
 * @Date 2020/4/3
 */

public class TestTimer {
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "定时间隔3s");
            }
        };
        Timer t = new Timer();
        long delay = 1000;
        long intevalTime = 3000;
        t.scheduleAtFixedRate(task,delay,intevalTime);
        t.schedule(task,1000);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟一秒，间隔3秒");
            }
        };
         ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
         executorService.scheduleAtFixedRate(runnable,1000,3000, TimeUnit.MILLISECONDS);

    }
}
