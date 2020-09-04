package com.radish.mashibing.concurrency;

/**
 * @Description V
 * @Author Radish
 * @Date 2020-09-04 10:42
 */
public class V {
    static class Data {
        int x, y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    volatile static Data data;

    public static void main(String[] args) {
        Thread writer = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                data = new Data(i, i);
                /*try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        });

        Thread reader = new Thread(() -> {
            while (data == null) {
            }
            int x = data.x;
            int y = data.y;
            if (x != y) {
                System.out.printf("a = %s, b = %s%n", x, y);
            }
        });

        writer.start();
        reader.start();

        try {
            writer.join();
            reader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");
    }
}
