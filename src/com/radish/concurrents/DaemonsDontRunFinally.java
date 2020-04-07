package com.radish.concurrents;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/20
 */

class ADaemon implements Runnable  {
    @Override
    public void run() {
        try {
            System.out.println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        } finally {
            System.out.println("This should always run?");
        }
    }
}

//嗷，后台线程的finally只有在有时间的时候才会执行，如果非后台进程已经结束，那么后台进程会突然结束，不会执行finally，不能优雅地关闭后台线程~
public class DaemonsDontRunFinally {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new ADaemon());
//        t.setDaemon(true);
        t.start();
    }

}

