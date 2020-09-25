package com.radish.jvm;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description TestHashMap
 * @Author Radish
 * @Date 2020-09-24 21:10
 */
public class TestHashMap {
    public static void main(String[] args) throws Exception {
        final HashMap<Integer, Integer> map = new HashMap<>();
        /*Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();*/

        System.out.println(map.size());

//        map.put("1","1");
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(i,i);
            concurrentHashMap.put(i,i);
        }
        map.put(null,1);
        map.put(101,null);

        concurrentHashMap.put(101,222);
    }
}
