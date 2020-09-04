package com.radish.mashibing.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description TestCyclicBarrier
 * @Author Radish
 * @Date 2020-09-04 13:48
 */
public class TestCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5,()-> System.out.println("满人，Go！"));

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(()->{
                int result = 0;
                for (int j = 0; j < 3; j++) {
                    result++;
                }
                System.out.println(finalI + result);

                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
