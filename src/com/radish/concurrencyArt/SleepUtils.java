package com.radish.concurrencyArt;

import java.util.concurrent.TimeUnit;

/**
 * @description SleepUtils
 * @Author Radish
 * @Date 2020-07-02 16:21:53
 */

public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
