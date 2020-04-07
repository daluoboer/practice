package com.radish.concurrents;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/21
 */

public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel() {canceled = true;}
    public boolean isCanceled() {return canceled;}
}
