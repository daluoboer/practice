package com.example.concurrents;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/21
 */

class UnresponsiveUI {
    private volatile double d = 1;

    public UnresponsiveUI() throws Exception {
        while (d > 0) {
            d = d + (Math.PI + Math.E) / d;
        }
        System.in.read();
    }
}
public class ResponsibveUI extends Thread{
    private static volatile double d = 1;

    public ResponsibveUI() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws Exception {
//        new UnresponsiveUI();
        /*这是一个后台线程，如果主线程没有结束，即用户没有输入，那么它就会一直计算下去，用户输入即可看到计算结果，主线程结束，后台线程随之结束*/
        new ResponsibveUI();
        System.in.read();
        System.out.println(d);
    }
}
