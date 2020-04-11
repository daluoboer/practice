package com.radish.thinking.unit21;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/20
 */

public class ExecutorTest {
    public static void main(String[] args) throws ExecutionException,InterruptedException {
        System.out.println("------程序开始运行------");
        Date date1 = new Date();

        int taskSize = 5;
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);

        List<Future> list = new ArrayList<>();
        for (int i = 0; i <taskSize; i++) {
            Callable callable = new MyCurCallable(i + " ");
            Future f = pool.submit(callable);
            list.add(f);
        }

        pool.shutdown();

        for (Future f : list) {
            System.out.println(">>>" + f.get().toString());
        }

        Date date2 = new Date();
        System.out.println("------程序运行结束------，程序运行时间【" + (date2.getTime()-date1.getTime()) + "】毫秒");
    }
}

class MyCurCallable implements Callable {
    private String taskNum;

    MyCurCallable(String taskNum){
        this.taskNum = taskNum;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(">>>" + taskNum + " 任务启动 ");
        Date date1 = new Date();
        Thread.sleep(1000);
        Date date2 = new Date();
        long time = date2.getTime()-date1.getTime();
        System.out.println(">>>" + taskNum + " 任务终止 ");
        return taskNum + "任务返回运行结果，当前任务时间【" + time +"】毫秒";
    }
}
