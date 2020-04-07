package com.radish.concurrents;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/20
 */

public class SelfManaged implements Runnable {
    private int countDown = 5;
    private Thread t = new Thread(this);

    /*在这里调用的问题：有可能调用一个处于不稳定状态的对象（因为可能构造器还没有执行结束之前就开始执行另一个任务了）
    * 这也是应该优选Executor而不是显式创建Thread的另一个原因*/
    public SelfManaged() {t.start();
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName() + "(" + countDown + "),";
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SelfManaged();
        }
    }
}
