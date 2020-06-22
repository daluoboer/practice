package com.radish.concurrent;

/**
 * @description FooBar
 *
 * 交替打印FooBar
 * 我们提供一个类：
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 *
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2:
 *
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 *
 * @Author Radish
 * @Date 2020-06-08 11:28:42
 */

public class FooBar {
    private int n;

    private boolean firstFinished = false;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while (!firstFinished) {
                synchronized (this) {
                }
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            firstFinished = true;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (firstFinished) {
                synchronized (this) {

                }
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            firstFinished = false;
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(1);
        Runnable foo = new Runnable() {
            @Override
            public void run() {
                System.out.print("foo");
            }
        };
        Runnable bar = new Runnable() {
            @Override
            public void run() {
                System.out.print("bar");
            }
        };
        try {
            fooBar.bar(bar);
            fooBar.foo(foo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
