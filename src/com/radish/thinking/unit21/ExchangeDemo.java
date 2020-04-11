package com.radish.thinking.unit21;

import com.radish.thinking.unit15.BasicGenerator;
import com.radish.thinking.unit15.Generator;

import java.util.List;
import java.util.concurrent.*;

/**
 * @Description ExchangeDemo
 * @Author Radish
 * @Date 2020/4/922:55
 */
class ExchangerProducer<T> implements Runnable {
    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;

    public ExchangerProducer(Generator<T> generator, Exchanger<List<T>> exchanger, List<T> holder) {
        this.generator = generator;
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < ExchangeDemo.size; i++)
                    holder.add(generator.next());
                holder = exchanger.exchange(holder);
            }
        } catch (InterruptedException e) {
            //
        }
    }
}

class ExchangerConsumer<T> implements Runnable {
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;

    public ExchangerConsumer(Exchanger<List<T>> exchanger, List<T> holder) {
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                holder = exchanger.exchange(holder);
                for (T x : holder) {
                    value = x;
                    holder.remove(x);
                }
            }
        } catch (InterruptedException e) {
            //
        }
        System.out.println("Final value: " + value);
    }
}
public class ExchangeDemo {
    static int size = 10;
    static int delay = 5;

    public static void main(String[] args) throws Exception {
        if (args.length > 0)
            size = new Integer(args[0]);
        if (args.length > 1)
            delay = new Integer(args[1]);
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<>();
        List<Fat> produceList = new CopyOnWriteArrayList<>(),
                consumerList = new CopyOnWriteArrayList<>();
        exec.execute(new ExchangerProducer<Fat>(BasicGenerator.create(Fat.class),xc,produceList));
        exec.execute(new ExchangerConsumer<Fat>(xc,consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();

    }
}
