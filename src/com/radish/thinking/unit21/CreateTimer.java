package com.radish.thinking.unit21;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/22
 */

public class CreateTimer {
    private static AtomicInteger index = new AtomicInteger(0);

    public static int getIndex() { return index.getAndAdd(1); }

    public static void getTimer() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("这是第 " + getIndex() + "个Timer，当前时间：" + new Date());
            }
        },0,2000);
    }

    public static Timer getTimer(long i,final String args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                System.out.println(args);
            }
        },0,i);
        return timer;
    }

}
