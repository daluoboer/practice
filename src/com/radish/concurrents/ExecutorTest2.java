package com.radish.concurrents;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/20
 */

public class ExecutorTest2 {
    public static void main(String[] args) {
        /*该方法应为首选，有特殊需求时可切换为其他方法*/
        /*ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        //shutDown是防止新任务被提交给这个exec
        exec.shutdown();

        //该方法可一次性预先执行代价高昂的线程分配，限制线程数量,唉？也可以在循环的时候弄>5条呀，喔~应该只是先分配5个，如果还需要更多就继续分配,啊！不是的！是只有这些线程！等前头的任务结束了，才把线程给其他的任务用~嗷~~~有一点点理解了耶，不是一根线程只能处理一个任务的~只是存在一根线程，那么菜谱就要给它分时间去处理这条线程上的任务~嗷嗷嗷~机智！被自己的聪明才智折服~
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
        //已经shutdown了再去调用就会报错：Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task LiftOff@4dd8dc3 rejected from java.util.concurrent.ThreadPoolExecutor@6d03e736[Shutting down, pool size = 5, active threads = 5, queued tasks = 5, completed tasks = 0]
        for (int i = 0; i < 10; i++) {
            exec.execute(new LiftOff());
        }*/

        //嗯~是滴，这就是一根线程了，所有的任务都在这根线程上执行，那跟FixedThreadPool不是没有区别咯？只是数量设为了1而已呀？不过页面备注说：它还提供了一种重要的并发机制，其他线程不会（即没有两个线程会）被并发调用。这会改变任务的加锁需求
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();

        //剩下这俩是啥呢？先跟着书上看看后头会不会讲到

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        ExecutorService executorService = Executors.newWorkStealingPool();


    }
}
