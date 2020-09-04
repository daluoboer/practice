package com.radish.mashibing.concurrency;

import java.util.Random;
import java.util.concurrent.Phaser;

/**
 * @Description TestPhaser
 * @Author Radish
 * @Date 2020-09-04 14:19
 */
public class TestPhaser {

    static Random r = new Random();
    static MarriagePhaser phaser = new MarriagePhaser();

    static class MarriagePhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("所有人到齐了！" + registeredParties + "\n");
                    return false;
                case 1:
                    System.out.println("所有人吃完了" + registeredParties + "\n");
                    return false;
                case 2:
                    System.out.println("所有人离开了" + registeredParties + "\n");
                    return false;
                case 3:
                    System.out.println("婚礼结束！新郎新娘抱抱！" + registeredParties);
                    System.out.println();
                    return true;
                default:
                    return true;
            }
        }
    }

    static class Person implements Runnable {
        String name;

        public Person(String name) {
            this.name = name;
        }

        public void arrive() {
            sleep(r.nextInt(1000));
            System.out.printf("%s到达\n",name);
            phaser.arriveAndAwaitAdvance();
        }

        public void eat() {
            sleep(r.nextInt(1000));
            System.out.printf("%s吃完\n",name);
            phaser.arriveAndAwaitAdvance();
        }

        public void leave() {
            sleep(r.nextInt(1000));
            System.out.printf("%s离开\n",name);
            phaser.arriveAndAwaitAdvance();
        }

        public void hug() {
            if (name.equals("新郎") || name.equals("新娘")) {
                sleep(r.nextInt(1000));
                System.out.printf("%s亲亲抱抱入洞房\n",name);
                phaser.arriveAndAwaitAdvance();
            } else {
                phaser.arriveAndDeregister();
            }
        }

        @Override
        public void run() {
            arrive();
            eat();
            leave();
            hug();
        }
    }

    public static void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        phaser.bulkRegister(7);
        for (int i = 0; i < 5; i++) {
            new Thread(new Person("p" + i)).start();
        }

        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();
    }
}