package com.example.concurrents;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/22
 */

public class TestTimer {
    public static void main(String[] args) throws ParseException,InterruptedException {
        Scanner in = new Scanner(System.in);

        /*Timer t1 = createTimer(1000,"2222");
        Timer t2 = createTimer(2000,"20");
        Thread.sleep(5000);
        t1.cancel();*/

        ArrayList<Timer> timers = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            timers.add(CreateTimer.getTimer(3000,"我是第" + (i+1) + "个Timer！"));
//            CreateTimer.getTimer();
        }

        Thread.sleep(5000);

        timers.get(0).cancel();

    }

    public static TimerTask createTask(final String args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(args);
            }
        };
        return timerTask;
    }

    //从某个时间开始的定时器
    public static Timer createTimer(int time,String args,String timeFormat,String date) throws ParseException {
        Timer timer = new Timer();
        DateFormat dateFormat = new SimpleDateFormat(timeFormat);
        timer.schedule(createTask(args),dateFormat.parse(date),time);
        return timer;
    }

    //从当前开始的定时器
    public static Timer createTimer(int time,final String args) throws ParseException {
        Timer timer = new Timer();
        timer.schedule(createTask(args),new Date(),time);
        return timer;
    }
}
