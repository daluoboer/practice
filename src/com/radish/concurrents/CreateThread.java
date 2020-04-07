package com.radish.concurrents;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/20
 */

    public class CreateThread {
        public static void main(String[] args) {
            PlayThread playThread = new PlayThread();
            playThread.start();
            EatAppleRunnable eatAppleRunnable = new EatAppleRunnable();
            Thread thread = new Thread(eatAppleRunnable);
            thread.start();
            DrawCallable drawCallable = new DrawCallable();
            FutureTask<String> futureTask = new FutureTask<>(drawCallable);
            new Thread(futureTask).start();
            try {
                System.out.println(futureTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

class PlayThread extends Thread {
    @Override
    public void run() {
        System.out.println(currentThread().getName() + ": It's time to play!");
    }
}

class EatAppleRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": I am eating apple! Delicious!");
    }
}

class DrawCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ": I am this thread.e.... I am drawing a picture!");
        return "Over";
    }
}
