package com.radish.some;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentTest {

    public static void main(String[] args) {
        System.out.println("-------------Concurrent------------");
        ConcurrentHashMap myMap = new ConcurrentHashMap();
        myMap.put("1","a");
        myMap.put("null","null");
        myMap.put("null",1);
        myMap.forEach((k,v)->{
            System.out.print(k + ": ");
            System.out.println(v);
        });

        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        queue.add(1);
        Object peek = queue.peek();

        ConcurrentLinkedDeque deque = new ConcurrentLinkedDeque();
        deque.add(1);
        deque.remove();
        deque.peek();

        System.out.println("----------HashMap----------");
        HashMap map = new HashMap();
        map.put("1",1);
        map.put("1",'a');
        map.put(null,null);

        map.forEach((k,v)->{
            System.out.print(k + ": ");
            System.out.println(v);
        });

        System.out.println("--------------ThreadLocal-----------");
        ThreadLocal local = new ThreadLocal();
        local.set("aaa");
        System.out.println(local.get());
    }
}
