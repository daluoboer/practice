package com.radish.concurrents;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @Description 这个代码没有敲完哦！懒得敲了~
 * @Author Radish
 * @Date 2020/3/24
 */

class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayedTask> sequence = new ArrayList<DelayedTask>();

    public DelayedTask(int delta) {
        this.delta = delta;
        trigger = System.nanoTime() + NANOSECONDS.convert(delta,MILLISECONDS);
        sequence.add(this);
    }
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(),MILLISECONDS);
    }

    public int compareTo(Delayed arg) {
        return 0;
    }

    @Override
    public void run() {

    }
}
public class DelayQueue {
}
