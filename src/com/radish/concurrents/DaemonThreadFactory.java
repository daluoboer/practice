package com.example.concurrents;

import java.util.concurrent.ThreadFactory;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/20
 */

public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
