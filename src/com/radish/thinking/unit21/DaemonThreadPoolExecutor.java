package com.radish.thinking.unit21;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/20
 */

public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {
    public DaemonThreadPoolExecutor() {
        super(0,Integer.MAX_VALUE,60L,TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),new DaemonThreadFactory());
    }
}
