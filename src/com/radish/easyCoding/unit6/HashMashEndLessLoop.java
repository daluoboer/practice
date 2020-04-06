package com.radish.easyCoding.unit6;

import java.util.HashMap;

public class HashMashEndLessLoop {
    private static HashMap<Long,EasyCoding> map = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            (new Thread(){
                public void run() {
                    map.put(System.nanoTime(),new EasyCoding());
                }
            }).start();
        }
        System.out.println(map.size());
    }
}

class EasyCoding{

}
